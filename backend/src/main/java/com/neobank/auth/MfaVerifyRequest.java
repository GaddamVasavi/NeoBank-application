package com.neobank.auth;
import jakarta.validation.constraints.NotBlank; import lombok.Data;
@Data public class MfaVerifyRequest {
    @NotBlank private String mfaSessionToken;
    @NotBlank private String code;
    private DeviceInfo deviceInfo;
}
