package com.neobank.analytics;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/analytics") @RequiredArgsConstructor
public class AnalyticsController {
    private final AnalyticsService analyticsService;
    @GetMapping("/cashflow") public ResponseEntity<ApiResponse<List<CashFlowDto>>> getCashFlow() { return ResponseEntity.ok(ApiResponse.success(analyticsService.getUserCashFlow(SecurityUtils.getCurrentUserId()))); }
}
