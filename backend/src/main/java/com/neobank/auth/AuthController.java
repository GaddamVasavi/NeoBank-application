package com.neobank.auth;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import jakarta.validation.Valid; import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/auth") @RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register") public ResponseEntity<ApiResponse<AuthResponse>> register(@Valid @RequestBody RegisterRequest request) { return ResponseEntity.ok(ApiResponse.success(authService.register(request), "Account created successfully")); }
    @PostMapping("/login") public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequest request) { return ResponseEntity.ok(ApiResponse.success(authService.login(request), "Authentication successful")); }
    @PostMapping("/verify-mfa") public ResponseEntity<ApiResponse<AuthResponse>> verifyMfa(@Valid @RequestBody MfaVerifyRequest request) { return ResponseEntity.ok(ApiResponse.success(authService.verifyMfa(request), "MFA verified")); }
    @PostMapping("/refresh-token") public ResponseEntity<ApiResponse<AuthResponse>> refreshToken(@Valid @RequestBody RefreshTokenRequest request) { return ResponseEntity.ok(ApiResponse.success(authService.refreshToken(request), "Token refreshed")); }
    @PostMapping("/logout") public ResponseEntity<ApiResponse<Void>> logout(@RequestBody(required = false) RefreshTokenRequest request) { authService.logout(SecurityUtils.getCurrentUserId(), request != null ? request.getRefreshToken() : null); return ResponseEntity.ok(ApiResponse.success(null, "Logged out")); }
    @PostMapping("/password-reset/request") public ResponseEntity<ApiResponse<Void>> requestPasswordReset(@Valid @RequestBody PasswordResetRequest request) { authService.requestPasswordReset(request); return ResponseEntity.ok(ApiResponse.success(null, "Instructions dispatched")); }
    @PostMapping("/password-reset/confirm") public ResponseEntity<ApiResponse<Void>> confirmPasswordReset(@Valid @RequestBody PasswordResetConfirmRequest request) { authService.confirmPasswordReset(request); return ResponseEntity.ok(ApiResponse.success(null, "Password reset successfully")); }
    @PostMapping("/otp/send") public ResponseEntity<ApiResponse<Void>> sendOtp(@RequestParam String target, @RequestParam OtpType type) { authService.sendOtp(target, type); return ResponseEntity.ok(ApiResponse.success(null, "OTP dispatched")); }
    @PostMapping("/otp/verify") public ResponseEntity<ApiResponse<Boolean>> verifyOtp(@Valid @RequestBody OtpVerifyRequest request) { boolean valid = authService.verifyOtp(request); return ResponseEntity.ok(ApiResponse.success(valid, valid ? "OTP valid" : "Invalid OTP")); }
    @GetMapping("/devices") public ResponseEntity<ApiResponse<List<DeviceResponse>>> getDevices() { return ResponseEntity.ok(ApiResponse.success(authService.getUserDevices(SecurityUtils.getCurrentUserId()))); }
    @PostMapping("/devices/{deviceId}/trust") public ResponseEntity<ApiResponse<Void>> trustDevice(@PathVariable UUID deviceId) { authService.trustDevice(SecurityUtils.getCurrentUserId(), deviceId); return ResponseEntity.ok(ApiResponse.success(null, "Device trusted")); }
    @DeleteMapping("/devices/{deviceId}") public ResponseEntity<ApiResponse<Void>> removeDevice(@PathVariable UUID deviceId) { authService.removeDevice(SecurityUtils.getCurrentUserId(), deviceId); return ResponseEntity.ok(ApiResponse.success(null, "Device removed")); }
}
