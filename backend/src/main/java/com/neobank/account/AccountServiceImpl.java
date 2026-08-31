package com.neobank.account;

import com.neobank.audit.AuditAction;
import com.neobank.audit.AuditService;
import com.neobank.audit.AuditSeverity;
import com.neobank.common.BadRequestException;
import com.neobank.common.CryptoUtils;
import com.neobank.common.ResourceNotFoundException;
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
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AuditService auditService;

    @Override
    @Transactional(readOnly = true)
    public List<AccountDto> getUserAccounts(UUID userId) {
        return accountRepository.findByUserId(userId).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AccountDto getAccountById(UUID accountId, UUID userId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));
        if (!account.getUser().getId().equals(userId)) {
            throw new BadRequestException("Account does not belong to authenticated customer");
        }
        return mapToDto(account);
    }

    @Override
    @Transactional
    public AccountDto createAccount(UUID userId, CreateAccountRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        String accountNumber = "400" + CryptoUtils.generateOtp(9);

        BigDecimal initialDeposit = request.getInitialDeposit() != null ? request.getInitialDeposit() : BigDecimal.ZERO;
        BigDecimal interestRate = request.getAccountType() == AccountType.SAVINGS ? new BigDecimal("4.25") : BigDecimal.ZERO;

        Account account = Account.builder()
                .user(user)
                .accountNumber(accountNumber)
                .accountType(request.getAccountType())
                .status(AccountStatus.ACTIVE)
                .currency(request.getCurrency() != null ? request.getCurrency() : "USD")
                .balance(initialDeposit)
                .availableBalance(initialDeposit)
                .interestRate(interestRate)
                .nickname(request.getNickname())
                .openedAt(Instant.now())
                .build();

        Account saved = accountRepository.save(account);
        auditService.log(userId, user.getUsername(), AuditAction.ACCOUNT_CREATE, "Account", saved.getId().toString(), "SUCCESS", "Account created: " + accountNumber, null, null, AuditSeverity.INFO);

        return mapToDto(saved);
    }

    @Override
    @Transactional
    public AccountDto updateAccountStatus(UUID accountId, UUID userId, AccountStatus status) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));
        if (!account.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");
        account.setStatus(status);
        return mapToDto(accountRepository.save(account));
    }

    @Override
    @Transactional
    public AccountDto updateLimits(UUID accountId, UUID userId, BigDecimal dailyLimit, BigDecimal singleLimit) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));
        if (!account.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");
        if (dailyLimit != null) account.setDailyTransferLimit(dailyLimit);
        if (singleLimit != null) account.setSingleTransferLimit(singleLimit);
        return mapToDto(accountRepository.save(account));
    }

    private AccountDto mapToDto(Account a) {
        return AccountDto.builder()
                .id(a.getId())
                .accountNumber(a.getAccountNumber())
                .accountType(a.getAccountType())
                .status(a.getStatus())
                .currency(a.getCurrency())
                .balance(a.getBalance())
                .availableBalance(a.getAvailableBalance())
                .interestRate(a.getInterestRate())
                .dailyTransferLimit(a.getDailyTransferLimit())
                .singleTransferLimit(a.getSingleTransferLimit())
                .routingNumber(a.getRoutingNumber())
                .nickname(a.getNickname())
                .openedAt(a.getOpenedAt())
                .build();
    }
}
