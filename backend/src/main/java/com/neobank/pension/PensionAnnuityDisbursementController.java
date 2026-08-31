package com.neobank.pension;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/pension/modules/pensionannuitydisbursement") @RequiredArgsConstructor
public class PensionAnnuityDisbursementController {
    private final PensionAnnuityDisbursementService service;
    @GetMapping public ResponseEntity<ApiResponse<List<PensionAnnuityDisbursementDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<PensionAnnuityDisbursementDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<PensionAnnuityDisbursementDto>> create(@RequestBody PensionAnnuityDisbursementDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/ref/{ref}") public ResponseEntity<ApiResponse<PensionAnnuityDisbursementDto>> getByRef(@PathVariable String ref) { return ResponseEntity.ok(ApiResponse.success(service.getByRef(ref))); }
    @PatchMapping("/{id}/status") public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) { service.updateStatus(id, status); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
