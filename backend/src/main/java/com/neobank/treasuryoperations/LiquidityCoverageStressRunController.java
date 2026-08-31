package com.neobank.treasuryoperations;
import com.neobank.common.ApiResponse;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/treasuryoperations/modules/liquiditycoveragestressrun") @RequiredArgsConstructor
public class LiquidityCoverageStressRunController {
    private final LiquidityCoverageStressRunService service;
    @GetMapping public ResponseEntity<ApiResponse<List<LiquidityCoverageStressRunDto>>> listAll() { return ResponseEntity.ok(ApiResponse.success(service.listAll())); }
    @GetMapping("/user/{userId}") public ResponseEntity<ApiResponse<List<LiquidityCoverageStressRunDto>>> getByUser(@PathVariable UUID userId) { return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId))); }
    @PostMapping public ResponseEntity<ApiResponse<LiquidityCoverageStressRunDto>> create(@RequestBody LiquidityCoverageStressRunDto dto) { return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created")); }
    @GetMapping("/id/{id}") public ResponseEntity<ApiResponse<LiquidityCoverageStressRunDto>> getByIdentifier(@PathVariable String id) { return ResponseEntity.ok(ApiResponse.success(service.getByIdentifier(id))); }
    @PatchMapping("/{id}/status") public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) { service.updateStatus(id, status); return ResponseEntity.ok(ApiResponse.success(null, "Updated")); }
}
