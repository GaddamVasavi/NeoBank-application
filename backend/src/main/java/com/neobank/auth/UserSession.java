package com.neobank.auth;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.time.Instant;
@Entity @Table(name = "user_sessions") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class UserSession extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "session_token_hash", nullable = false, unique = true, length = 128) private String sessionTokenHash;
    @Column(name = "ip_address", length = 45) private String ipAddress;
    @Column(name = "user_agent", length = 255) private String userAgent;
    @Column(name = "device_id", length = 128) private String deviceId;
    @Column(name = "is_active", nullable = false) @Builder.Default private boolean active = true;
    @Column(name = "last_activity_at", nullable = false) @Builder.Default private Instant lastActivityAt = Instant.now();
    @Column(name = "expires_at", nullable = false) private Instant expiresAt;
}
