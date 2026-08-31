package com.neobank.marketing;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/marketing/modules/gamificationbadgerecord") @RequiredArgsConstructor
public class GamificationBadgeRecordController {
    private final GamificationBadgeRecordService service;
    @GetMapping public ResponseEntity<ApiResponse<List<GamificationBadgeRecordDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<GamificationBadgeRecordDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<GamificationBadgeRecordDto>> create(@RequestBody GamificationBadgeRecordDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/code/{code}") public ResponseEntity<ApiResponse<GamificationBadgeRecordDto>> getByCode(@PathVariable String code) { return ResponseEntity.ok(ApiResponse.success(service.getByCode(code))); }
    @PatchMapping("/{id}/state") public ResponseEntity<ApiResponse<Void>> updateState(@PathVariable UUID id, @RequestParam String state) { service.updateState(id, state); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
