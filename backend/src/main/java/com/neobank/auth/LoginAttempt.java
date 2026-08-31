package com.neobank.auth;
import com.neobank.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
import java.time.Instant;
@Entity @Table(name = "login_attempts") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class LoginAttempt extends BaseEntity {
    @Column(name = "username_or_email", nullable = false, length = 120) private String usernameOrEmail;
    @Column(name = "ip_address", length = 45) private String ipAddress;
    @Column(name = "user_agent", length = 255) private String userAgent;
    @Column(name = "success", nullable = false) private boolean success;
    @Column(name = "failure_reason", length = 100) private String failureReason;
    @Column(name = "attempted_at", nullable = false) @Builder.Default private Instant attemptedAt = Instant.now();
}
