package com.neobank.transaction;
import com.neobank.account.Account; import com.neobank.account.AccountRepository;
import com.neobank.common.BadRequestException; import com.neobank.common.PagedResponse; import com.neobank.common.ResourceNotFoundException;
import lombok.RequiredArgsConstructor; import org.springframework.data.domain.Page; import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Override @Transactional(readOnly = true)
    public PagedResponse<TransactionDto> getAccountTransactions(UUID accountId, UUID userId, Pageable pageable) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));
        if (!account.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");
        Page<Transaction> page = transactionRepository.findByAccountIdOrderByTransactionDateDesc(accountId, pageable);
        return PagedResponse.fromPage(page.map(this::mapToDto));
    }

    @Override @Transactional(readOnly = true)
    public List<TransactionDto> getRecentTransactions(UUID accountId, UUID userId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));
        if (!account.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");
        return transactionRepository.findTop10ByAccountIdOrderByTransactionDateDesc(accountId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override @Transactional(readOnly = true)
    public TransactionDto getTransactionByRef(String refNumber, UUID userId) {
        Transaction t = transactionRepository.findByReferenceNumber(refNumber).orElseThrow(() -> new ResourceNotFoundException("Transaction", "ref", refNumber));
        return mapToDto(t);
    }

    private TransactionDto mapToDto(Transaction t) {
        return TransactionDto.builder()
                .id(t.getId())
                .accountId(t.getAccount().getId())
                .referenceNumber(t.getReferenceNumber())
                .transactionType(t.getTransactionType())
                .category(t.getCategory())
                .amount(t.getAmount())
                .fee(t.getFee())
                .currency(t.getCurrency())
                .balanceAfter(t.getBalanceAfter())
                .description(t.getDescription())
                .status(t.getStatus())
                .counterpartyAccount(t.getCounterpartyAccount())
                .counterpartyName(t.getCounterpartyName())
                .transactionDate(t.getTransactionDate())
                .build();
    }
}
