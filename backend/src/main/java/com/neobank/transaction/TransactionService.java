package com.neobank.transaction;
import com.neobank.common.PagedResponse; import org.springframework.data.domain.Pageable;
import java.util.List; import java.util.UUID;
public interface TransactionService {
    PagedResponse<TransactionDto> getAccountTransactions(UUID accountId, UUID userId, Pageable pageable);
    List<TransactionDto> getRecentTransactions(UUID accountId, UUID userId);
    TransactionDto getTransactionByRef(String refNumber, UUID userId);
}
