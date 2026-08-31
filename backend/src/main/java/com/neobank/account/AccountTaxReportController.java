package com.neobank.account;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/accounts/modules/accounttaxreport") @RequiredArgsConstructor
public class AccountTaxReportController {
    private final AccountTaxReportService service;
    @GetMapping("/account/{accountId}") public ResponseEntity<ApiResponse<List<AccountTaxReportDto>>> getByAccount(@PathVariable UUID accountId) { return ResponseEntity.ok(ApiResponse.success(service.getByAccount(accountId))); }
    @PostMapping public ResponseEntity<ApiResponse<AccountTaxReportDto>> create(@RequestBody AccountTaxReportDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created successfully")); }
    @GetMapping("/ref/{ref}") public ResponseEntity<ApiResponse<AccountTaxReportDto>> getByRef(@PathVariable String ref) { return ResponseEntity.ok(ApiResponse.success(service.getByRef(ref))); }
    @PatchMapping("/{id}/status") public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) { service.updateStatus(id, status); return ResponseEntity.ok(ApiResponse.success(null, "Status updated")); }
}
