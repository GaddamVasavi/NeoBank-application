package com.neobank.identity;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/identity/modules/webauthncredentialrecord") @RequiredArgsConstructor
public class WebAuthnCredentialRecordController {
    private final WebAuthnCredentialRecordService service;
    @GetMapping public ResponseEntity<ApiResponse<List<WebAuthnCredentialRecordDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<WebAuthnCredentialRecordDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<WebAuthnCredentialRecordDto>> create(@RequestBody WebAuthnCredentialRecordDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/key/{key}") public ResponseEntity<ApiResponse<WebAuthnCredentialRecordDto>> getByKey(@PathVariable String key) { return ResponseEntity.ok(ApiResponse.success(service.getByKey(key))); }
    @PatchMapping("/{id}/status") public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) { service.updateStatus(id, status); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
