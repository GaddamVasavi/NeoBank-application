package com.neobank.user;

import com.neobank.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_preferences")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPreference extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "theme", nullable = false, length = 20)
    @Builder.Default
    private String theme = "DARK";

    @Column(name = "currency", nullable = false, length = 10)
    @Builder.Default
    private String currency = "USD";

    @Column(name = "language", nullable = false, length = 10)
    @Builder.Default
    private String language = "en";

    @Column(name = "email_notifications", nullable = false)
    @Builder.Default
    private boolean emailNotifications = true;

    @Column(name = "sms_notifications", nullable = false)
    @Builder.Default
    private boolean smsNotifications = true;

    @Column(name = "push_notifications", nullable = false)
    @Builder.Default
    private boolean pushNotifications = true;

    @Column(name = "marketing_emails", nullable = false)
    @Builder.Default
    private boolean marketingEmails = false;

    @Column(name = "two_factor_on_login", nullable = false)
    @Builder.Default
    private boolean twoFactorOnLogin = false;

    @Column(name = "two_factor_on_transfer", nullable = false)
    @Builder.Default
    private boolean twoFactorOnTransfer = true;
}
