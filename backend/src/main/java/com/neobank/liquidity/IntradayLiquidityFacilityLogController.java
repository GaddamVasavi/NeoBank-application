package com.neobank.liquidity;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/liquidity/modules/intradayliquidityfacilitylog") @RequiredArgsConstructor
public class IntradayLiquidityFacilityLogController {
    private final IntradayLiquidityFacilityLogService service;
    @GetMapping public ResponseEntity<ApiResponse<List<IntradayLiquidityFacilityLogDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<IntradayLiquidityFacilityLogDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<IntradayLiquidityFacilityLogDto>> create(@RequestBody IntradayLiquidityFacilityLogDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/id/{id}") public ResponseEntity<ApiResponse<IntradayLiquidityFacilityLogDto>> getByIdentifier(@PathVariable String id) { return ResponseEntity.ok(ApiResponse.success(service.getByIdentifier(id))); }
    @PatchMapping("/{id}/state") public ResponseEntity<ApiResponse<Void>> updateState(@PathVariable UUID id, @RequestParam String state) { service.updateState(id, state); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
