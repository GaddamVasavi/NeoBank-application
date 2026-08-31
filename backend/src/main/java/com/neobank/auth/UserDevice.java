package com.neobank.auth;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.time.Instant;
@Entity @Table(name = "user_devices") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class UserDevice extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "device_fingerprint", nullable = false, length = 128) private String deviceFingerprint;
    @Column(name = "device_name", length = 100) private String deviceName;
    @Column(name = "device_type", length = 40) private String deviceType;
    @Column(name = "operating_system", length = 50) private String operatingSystem;
    @Column(name = "browser", length = 50) private String browser;
    @Column(name = "ip_address", length = 45) private String ipAddress;
    @Column(name = "city", length = 80) private String city;
    @Column(name = "country", length = 60) private String country;
    @Column(name = "is_trusted", nullable = false) @Builder.Default private boolean trusted = false;
    @Column(name = "last_active_at") private Instant lastActiveAt;
}
