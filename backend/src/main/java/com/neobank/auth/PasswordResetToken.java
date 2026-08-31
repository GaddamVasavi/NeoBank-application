package com.neobank.auth;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.time.Instant;
@Entity @Table(name = "password_reset_tokens") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class PasswordResetToken extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "token_hash", nullable = false, unique = true, length = 255) private String tokenHash;
    @Column(name = "expires_at", nullable = false) private Instant expiresAt;
    @Column(name = "used", nullable = false) @Builder.Default private boolean used = false;
    public boolean isValid() { return !this.used && Instant.now().isBefore(this.expiresAt); }
}
