package com.neobank.marketing;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/marketing/modules/promotionalcampaignschedule") @RequiredArgsConstructor
public class PromotionalCampaignScheduleController {
    private final PromotionalCampaignScheduleService service;
    @GetMapping public ResponseEntity<ApiResponse<List<PromotionalCampaignScheduleDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<PromotionalCampaignScheduleDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<PromotionalCampaignScheduleDto>> create(@RequestBody PromotionalCampaignScheduleDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/code/{code}") public ResponseEntity<ApiResponse<PromotionalCampaignScheduleDto>> getByCode(@PathVariable String code) { return ResponseEntity.ok(ApiResponse.success(service.getByCode(code))); }
    @PatchMapping("/{id}/state") public ResponseEntity<ApiResponse<Void>> updateState(@PathVariable UUID id, @RequestParam String state) { service.updateState(id, state); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
