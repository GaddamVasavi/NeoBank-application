package com.neobank.fraud;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/admin/fraud") @RequiredArgsConstructor
public class FraudController {
    private final FraudService fraudService;
    @GetMapping("/cases") public ResponseEntity<ApiResponse<List<FraudCase>>> getOpenCases() { return ResponseEntity.ok(ApiResponse.success(fraudService.getOpenCases())); }
    @PostMapping("/cases/{caseId}/resolve") public ResponseEntity<ApiResponse<Void>> resolveCase(@PathVariable UUID caseId, @RequestParam String resolution, @RequestParam String notes) { fraudService.resolveCase(caseId, SecurityUtils.getCurrentUserId(), resolution, notes); return ResponseEntity.ok(ApiResponse.success(null, "Case resolved")); }
    @GetMapping("/rules") public ResponseEntity<ApiResponse<List<FraudRule>>> getRules() { return ResponseEntity.ok(ApiResponse.success(fraudService.getRules())); }
}
