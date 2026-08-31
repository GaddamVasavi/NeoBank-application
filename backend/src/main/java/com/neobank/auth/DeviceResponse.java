package com.neobank.auth;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class DeviceResponse {
    private UUID id;
    private String deviceFingerprint;
    private String deviceName;
    private String deviceType;
    private String operatingSystem;
    private String browser;
    private String ipAddress;
    private String city;
    private String country;
    private boolean trusted;
    private Instant lastActiveAt;
}
