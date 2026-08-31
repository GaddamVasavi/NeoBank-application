package com.neobank.account;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import jakarta.validation.Valid; import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal; import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/accounts") @RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @GetMapping public ResponseEntity<ApiResponse<List<AccountDto>>> getAccounts() { return ResponseEntity.ok(ApiResponse.success(accountService.getUserAccounts(SecurityUtils.getCurrentUserId()))); }
    @GetMapping("/{accountId}") public ResponseEntity<ApiResponse<AccountDto>> getAccount(@PathVariable UUID accountId) { return ResponseEntity.ok(ApiResponse.success(accountService.getAccountById(accountId, SecurityUtils.getCurrentUserId()))); }
    @PostMapping public ResponseEntity<ApiResponse<AccountDto>> createAccount(@Valid @RequestBody CreateAccountRequest request) { return ResponseEntity.ok(ApiResponse.success(accountService.createAccount(SecurityUtils.getCurrentUserId(), request), "Account opened")); }
    @PatchMapping("/{accountId}/status") public ResponseEntity<ApiResponse<AccountDto>> updateStatus(@PathVariable UUID accountId, @RequestParam AccountStatus status) { return ResponseEntity.ok(ApiResponse.success(accountService.updateAccountStatus(accountId, SecurityUtils.getCurrentUserId(), status), "Status updated")); }
    @PatchMapping("/{accountId}/limits") public ResponseEntity<ApiResponse<AccountDto>> updateLimits(@PathVariable UUID accountId, @RequestParam(required = false) BigDecimal dailyLimit, @RequestParam(required = false) BigDecimal singleLimit) { return ResponseEntity.ok(ApiResponse.success(accountService.updateLimits(accountId, SecurityUtils.getCurrentUserId(), dailyLimit, singleLimit), "Limits updated")); }
}
