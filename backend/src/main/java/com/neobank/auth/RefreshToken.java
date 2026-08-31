package com.neobank.auth;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.time.Instant;
@Entity @Table(name = "refresh_tokens") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class RefreshToken extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "token_hash", nullable = false, unique = true, length = 255) private String tokenHash;
    @Column(name = "device_id", length = 120) private String deviceId;
    @Column(name = "device_name", length = 120) private String deviceName;
    @Column(name = "ip_address", length = 45) private String ipAddress;
    @Column(name = "user_agent", length = 255) private String userAgent;
    @Column(name = "expires_at", nullable = false) private Instant expiresAt;
    @Column(name = "revoked", nullable = false) @Builder.Default private boolean revoked = false;
    @Column(name = "revoked_at") private Instant revokedAt;
    public boolean isValid() { return !this.revoked && Instant.now().isBefore(this.expiresAt); }
}
