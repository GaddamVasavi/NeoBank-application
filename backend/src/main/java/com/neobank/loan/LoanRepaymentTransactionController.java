package com.neobank.loan;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/loan/modules/loanrepaymenttransaction") @RequiredArgsConstructor
public class LoanRepaymentTransactionController {
    private final LoanRepaymentTransactionService service;
    @GetMapping public ResponseEntity<ApiResponse<List<LoanRepaymentTransactionDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<LoanRepaymentTransactionDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<LoanRepaymentTransactionDto>> create(@RequestBody LoanRepaymentTransactionDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/key/{key}") public ResponseEntity<ApiResponse<LoanRepaymentTransactionDto>> getByKey(@PathVariable String key) { return ResponseEntity.ok(ApiResponse.success(service.getByKey(key))); }
    @PatchMapping("/{id}/status") public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) { service.updateStatus(id, status); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
