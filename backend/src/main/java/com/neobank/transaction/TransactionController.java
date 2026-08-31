package com.neobank.transaction;
import com.neobank.common.ApiResponse; import com.neobank.common.PagedResponse; import com.neobank.security.SecurityUtils;
import lombok.RequiredArgsConstructor; import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/transactions") @RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @GetMapping("/account/{accountId}") public ResponseEntity<ApiResponse<PagedResponse<TransactionDto>>> getAccountTransactions(@PathVariable UUID accountId, Pageable pageable) { return ResponseEntity.ok(ApiResponse.success(transactionService.getAccountTransactions(accountId, SecurityUtils.getCurrentUserId(), pageable))); }
    @GetMapping("/account/{accountId}/recent") public ResponseEntity<ApiResponse<List<TransactionDto>>> getRecentTransactions(@PathVariable UUID accountId) { return ResponseEntity.ok(ApiResponse.success(transactionService.getRecentTransactions(accountId, SecurityUtils.getCurrentUserId()))); }
    @GetMapping("/{referenceNumber}") public ResponseEntity<ApiResponse<TransactionDto>> getTransaction(@PathVariable String referenceNumber) { return ResponseEntity.ok(ApiResponse.success(transactionService.getTransactionByRef(referenceNumber, SecurityUtils.getCurrentUserId()))); }
}
