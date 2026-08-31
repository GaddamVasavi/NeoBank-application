package com.neobank.auth;
import java.util.List; import java.util.UUID;
public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    AuthResponse verifyMfa(MfaVerifyRequest request);
    AuthResponse refreshToken(RefreshTokenRequest request);
    void logout(UUID userId, String refreshToken);
    void requestPasswordReset(PasswordResetRequest request);
    void confirmPasswordReset(PasswordResetConfirmRequest request);
    void sendOtp(String contactTarget, OtpType type);
    boolean verifyOtp(OtpVerifyRequest request);
    List<DeviceResponse> getUserDevices(UUID userId);
    void trustDevice(UUID userId, UUID deviceId);
    void removeDevice(UUID userId, UUID deviceId);
}
