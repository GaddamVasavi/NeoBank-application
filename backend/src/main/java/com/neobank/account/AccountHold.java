package com.neobank.account;
import com.neobank.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant;
@Entity @Table(name = "account_holds") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountHold extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "account_id", nullable = false) private Account account;
    @Column(name = "amount", nullable = false, precision = 15, scale = 2) private BigDecimal amount;
    @Column(name = "hold_reason", nullable = false, length = 150) private String holdReason;
    @Column(name = "reference_id", nullable = false, length = 36) private String referenceId;
    @Column(name = "is_active", nullable = false) @Builder.Default private boolean active = true;
    @Column(name = "expires_at") private Instant expiresAt;
}
