package com.neobank.digitalvault;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/digitalvault/modules/digitalidentityclaimrecord") @RequiredArgsConstructor
public class DigitalIdentityClaimRecordController {
    private final DigitalIdentityClaimRecordService service;
    @GetMapping public ResponseEntity<ApiResponse<List<DigitalIdentityClaimRecordDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<DigitalIdentityClaimRecordDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<DigitalIdentityClaimRecordDto>> create(@RequestBody DigitalIdentityClaimRecordDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/ref/{ref}") public ResponseEntity<ApiResponse<DigitalIdentityClaimRecordDto>> getByRef(@PathVariable String ref) { return ResponseEntity.ok(ApiResponse.success(service.getByRef(ref))); }
    @PatchMapping("/{id}/state") public ResponseEntity<ApiResponse<Void>> updateState(@PathVariable UUID id, @RequestParam String state) { service.updateState(id, state); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
