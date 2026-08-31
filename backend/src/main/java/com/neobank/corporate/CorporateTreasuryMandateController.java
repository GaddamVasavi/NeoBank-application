package com.neobank.corporate;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/corporate/modules/corporatetreasurymandate") @RequiredArgsConstructor
public class CorporateTreasuryMandateController {
    private final CorporateTreasuryMandateService service;
    @GetMapping public ResponseEntity<ApiResponse<List<CorporateTreasuryMandateDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<CorporateTreasuryMandateDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<CorporateTreasuryMandateDto>> create(@RequestBody CorporateTreasuryMandateDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/code/{code}") public ResponseEntity<ApiResponse<CorporateTreasuryMandateDto>> getByCode(@PathVariable String code) { return ResponseEntity.ok(ApiResponse.success(service.getByCode(code))); }
    @PatchMapping("/{id}/state") public ResponseEntity<ApiResponse<Void>> updateState(@PathVariable UUID id, @RequestParam String state) { service.updateState(id, state); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
