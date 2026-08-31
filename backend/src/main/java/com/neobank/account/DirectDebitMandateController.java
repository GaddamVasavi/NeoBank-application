package com.neobank.account;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/accounts/modules/directdebitmandate") @RequiredArgsConstructor
public class DirectDebitMandateController {
    private final DirectDebitMandateService service;
    @GetMapping("/account/{accountId}") public ResponseEntity<ApiResponse<List<DirectDebitMandateDto>>> getByAccount(@PathVariable UUID accountId) { return ResponseEntity.ok(ApiResponse.success(service.getByAccount(accountId))); }
    @PostMapping public ResponseEntity<ApiResponse<DirectDebitMandateDto>> create(@RequestBody DirectDebitMandateDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created successfully")); }
    @GetMapping("/ref/{ref}") public ResponseEntity<ApiResponse<DirectDebitMandateDto>> getByRef(@PathVariable String ref) { return ResponseEntity.ok(ApiResponse.success(service.getByRef(ref))); }
    @PatchMapping("/{id}/status") public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) { service.updateStatus(id, status); return ResponseEntity.ok(ApiResponse.success(null, "Status updated")); }
}
