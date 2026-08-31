package com.neobank.account;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/accounts/modules/overdraftfacility") @RequiredArgsConstructor
public class OverdraftFacilityController {
    private final OverdraftFacilityService service;
    @GetMapping("/account/{accountId}") public ResponseEntity<ApiResponse<List<OverdraftFacilityDto>>> getByAccount(@PathVariable UUID accountId) { return ResponseEntity.ok(ApiResponse.success(service.getByAccount(accountId))); }
    @PostMapping public ResponseEntity<ApiResponse<OverdraftFacilityDto>> create(@RequestBody OverdraftFacilityDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created successfully")); }
    @GetMapping("/ref/{ref}") public ResponseEntity<ApiResponse<OverdraftFacilityDto>> getByRef(@PathVariable String ref) { return ResponseEntity.ok(ApiResponse.success(service.getByRef(ref))); }
    @PatchMapping("/{id}/status") public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) { service.updateStatus(id, status); return ResponseEntity.ok(ApiResponse.success(null, "Status updated")); }
}
