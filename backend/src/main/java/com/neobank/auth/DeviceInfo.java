package com.neobank.auth;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class DeviceInfo {
    private String deviceFingerprint;
    private String deviceName;
    private String deviceType;
    private String operatingSystem;
    private String browser;
    private String ipAddress;
}
