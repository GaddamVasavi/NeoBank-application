package com.neobank.loan;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal; import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/loans") @RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;
    @GetMapping("/products") public ResponseEntity<ApiResponse<List<LoanProduct>>> getProducts() { return ResponseEntity.ok(ApiResponse.success(loanService.getLoanProducts())); }
    @GetMapping public ResponseEntity<ApiResponse<List<Loan>>> getLoans() { return ResponseEntity.ok(ApiResponse.success(loanService.getUserLoans(SecurityUtils.getCurrentUserId()))); }
    @PostMapping("/apply") public ResponseEntity<ApiResponse<Loan>> apply(@RequestParam UUID accountId, @RequestParam UUID productId, @RequestParam BigDecimal principal, @RequestParam int tenureMonths) { return ResponseEntity.ok(ApiResponse.success(loanService.applyForLoan(SecurityUtils.getCurrentUserId(), accountId, productId, principal, tenureMonths), "Loan approved and disbursed")); }
    @GetMapping("/calculator") public ResponseEntity<ApiResponse<BigDecimal>> calculate(@RequestParam BigDecimal principal, @RequestParam BigDecimal rate, @RequestParam int months) { return ResponseEntity.ok(ApiResponse.success(loanService.calculateEmi(principal, rate, months))); }
}
