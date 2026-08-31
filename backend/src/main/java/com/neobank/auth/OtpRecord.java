package com.neobank.auth;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.time.Instant;
@Entity @Table(name = "otp_records") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class OtpRecord extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "contact_target", nullable = false, length = 120) private String contactTarget;
    @Column(name = "otp_code", nullable = false, length = 10) private String otpCode;
    @Enumerated(EnumType.STRING) @Column(name = "otp_type", nullable = false, length = 40) private OtpType otpType;
    @Column(name = "expires_at", nullable = false) private Instant expiresAt;
    @Column(name = "verified", nullable = false) @Builder.Default private boolean verified = false;
    @Column(name = "attempts_count", nullable = false) @Builder.Default private int attemptsCount = 0;
    public boolean isExpired() { return Instant.now().isAfter(this.expiresAt); }
}
