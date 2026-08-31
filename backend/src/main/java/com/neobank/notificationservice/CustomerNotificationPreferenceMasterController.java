package com.neobank.notificationservice;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/notificationservice/modules/customernotificationpreferencemaster") @RequiredArgsConstructor
public class CustomerNotificationPreferenceMasterController {
    private final CustomerNotificationPreferenceMasterService service;
    @GetMapping public ResponseEntity<ApiResponse<List<CustomerNotificationPreferenceMasterDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<CustomerNotificationPreferenceMasterDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<CustomerNotificationPreferenceMasterDto>> create(@RequestBody CustomerNotificationPreferenceMasterDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/key/{key}") public ResponseEntity<ApiResponse<CustomerNotificationPreferenceMasterDto>> getByKey(@PathVariable String key) { return ResponseEntity.ok(ApiResponse.success(service.getByKey(key))); }
    @PatchMapping("/{id}/status") public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) { service.updateStatus(id, status); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
