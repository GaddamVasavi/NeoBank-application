package com.neobank.bill;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal; import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/bills") @RequiredArgsConstructor
public class BillController {
    private final BillService billService;
    @GetMapping("/billers") public ResponseEntity<ApiResponse<List<Biller>>> getBillers() { return ResponseEntity.ok(ApiResponse.success(billService.getBillers())); }
    @PostMapping("/pay") public ResponseEntity<ApiResponse<BillPayment>> payBill(@RequestParam UUID accountId, @RequestParam UUID billerId, @RequestParam String consumerNumber, @RequestParam BigDecimal amount) { return ResponseEntity.ok(ApiResponse.success(billService.payBill(SecurityUtils.getCurrentUserId(), accountId, billerId, consumerNumber, amount), "Bill paid successfully")); }
    @GetMapping("/history/{accountId}") public ResponseEntity<ApiResponse<List<BillPayment>>> getHistory(@PathVariable UUID accountId) { return ResponseEntity.ok(ApiResponse.success(billService.getAccountBillPayments(SecurityUtils.getCurrentUserId(), accountId))); }
}
