package com.neobank.auth;
import jakarta.validation.constraints.NotBlank; import lombok.Data;
@Data public class OtpVerifyRequest {
    @NotBlank private String contactTarget;
    @NotBlank private String otpCode;
    private OtpType otpType;
}
