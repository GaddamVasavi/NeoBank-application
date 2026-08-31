package com.neobank.transfer;

import com.neobank.account.Account;
import com.neobank.account.AccountRepository;
import com.neobank.account.AccountStatus;
import com.neobank.audit.AuditAction;
import com.neobank.audit.AuditService;
import com.neobank.audit.AuditSeverity;
import com.neobank.common.BadRequestException;
import com.neobank.common.CryptoUtils;
import com.neobank.common.ResourceNotFoundException;
import com.neobank.transaction.Transaction;
import com.neobank.transaction.TransactionRepository;
import com.neobank.transaction.TransactionStatus;
import com.neobank.transaction.TransactionType;
import com.neobank.user.User;
import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;
    private final BeneficiaryRepository beneficiaryRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final AuditService auditService;

    @Override
    @Transactional
    public TransferResponse executeTransfer(UUID userId, TransferRequest request) {
        if (request.getIdempotencyKey() != null) {
            var existing = transferRepository.findByIdempotencyKey(request.getIdempotencyKey());
            if (existing.isPresent()) {
                Transfer t = existing.get();
                return TransferResponse.builder()
                        .transferId(t.getId())
                        .referenceId(t.getReferenceId())
                        .status(t.getStatus())
                        .amount(t.getAmount())
                        .currency(t.getCurrency())
                        .timestamp(t.getCreatedAt())
                        .message("Idempotent response: transfer already recorded")
                        .build();
            }
        }

        Account source = accountRepository.findById(request.getSourceAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Source Account not found"));

        if (!source.getUser().getId().equals(userId)) {
            throw new BadRequestException("Source account does not belong to user");
        }
        if (source.getStatus() != AccountStatus.ACTIVE) {
            throw new BadRequestException("Source account is not active");
        }
        if (source.getAvailableBalance().compareTo(request.getAmount()) < 0) {
            throw new BadRequestException("Insufficient available funds");
        }

        // Deduct source
        source.setBalance(source.getBalance().subtract(request.getAmount()));
        source.setAvailableBalance(source.getAvailableBalance().subtract(request.getAmount()));
        accountRepository.save(source);

        String ref = "TRF-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        Transaction debitTx = Transaction.builder()
                .account(source)
                .referenceNumber(ref + "-DR")
                .transactionType(TransactionType.TRANSFER_OUT)
                .category("TRANSFER")
                .amount(request.getAmount().negate())
                .balanceAfter(source.getBalance())
                .description(request.getNote() != null ? request.getNote() : "Transfer Out")
                .status(TransactionStatus.COMPLETED)
                .transactionDate(Instant.now())
                .build();
        transactionRepository.save(debitTx);

        // If destination account specified in NeoBank
        if (request.getDestinationAccountId() != null) {
            Account dest = accountRepository.findById(request.getDestinationAccountId()).orElse(null);
            if (dest != null && dest.getStatus() == AccountStatus.ACTIVE) {
                dest.setBalance(dest.getBalance().add(request.getAmount()));
                dest.setAvailableBalance(dest.getAvailableBalance().add(request.getAmount()));
                accountRepository.save(dest);

                Transaction creditTx = Transaction.builder()
                        .account(dest)
                        .referenceNumber(ref + "-CR")
                        .transactionType(TransactionType.TRANSFER_IN)
                        .category("TRANSFER")
                        .amount(request.getAmount())
                        .balanceAfter(dest.getBalance())
                        .description("Transfer In from " + source.getAccountNumber())
                        .status(TransactionStatus.COMPLETED)
                        .transactionDate(Instant.now())
                        .build();
                transactionRepository.save(creditTx);
            }
        }

        Transfer transfer = Transfer.builder()
                .sourceAccount(source)
                .referenceId(ref)
                .idempotencyKey(request.getIdempotencyKey())
                .transferType(request.getTransferType())
                .amount(request.getAmount())
                .status(TransferStatus.COMPLETED)
                .note(request.getNote())
                .executedAt(Instant.now())
                .build();
        Transfer saved = transferRepository.save(transfer);

        auditService.log(userId, source.getUser().getUsername(), AuditAction.TRANSFER, "Transfer", saved.getId().toString(), "SUCCESS", "Transfer completed: " + ref, null, null, AuditSeverity.INFO);

        return TransferResponse.builder()
                .transferId(saved.getId())
                .referenceId(ref)
                .status(TransferStatus.COMPLETED)
                .amount(request.getAmount())
                .currency(source.getCurrency())
                .timestamp(Instant.now())
                .message("Transfer executed successfully")
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<BeneficiaryDto> getUserBeneficiaries(UUID userId) {
        return beneficiaryRepository.findByUserId(userId).stream()
                .map(b -> BeneficiaryDto.builder()
                        .id(b.getId())
                        .name(b.getName())
                        .nickname(b.getNickname())
                        .accountNumber(b.getAccountNumber())
                        .bankName(b.getBankName())
                        .internal(b.isInternal())
                        .favorite(b.isFavorite())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BeneficiaryDto addBeneficiary(UUID userId, BeneficiaryDto dto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Beneficiary b = Beneficiary.builder()
                .user(user)
                .name(dto.getName())
                .nickname(dto.getNickname())
                .accountNumber(dto.getAccountNumber())
                .bankName(dto.getBankName() != null ? dto.getBankName() : "NeoBank")
                .internal(dto.isInternal())
                .favorite(dto.isFavorite())
                .build();
        Beneficiary saved = beneficiaryRepository.save(b);
        return BeneficiaryDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .nickname(saved.getNickname())
                .accountNumber(saved.getAccountNumber())
                .bankName(saved.getBankName())
                .internal(saved.isInternal())
                .favorite(saved.isFavorite())
                .build();
    }

    @Override
    @Transactional
    public void deleteBeneficiary(UUID userId, UUID beneficiaryId) {
        Beneficiary b = beneficiaryRepository.findById(beneficiaryId).orElseThrow(() -> new ResourceNotFoundException("Beneficiary not found"));
        if (!b.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");
        beneficiaryRepository.delete(b);
    }
}
