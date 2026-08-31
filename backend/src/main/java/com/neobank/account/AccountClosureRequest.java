package com.neobank.account;

import com.neobank.common.BaseEntity;
import com.neobank.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/** Account closure review workflows, final payout destination, and audit settlement */
@Entity
@Table(name = "accountclosurerequests")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountClosureRequest extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "reference_code", nullable = false, unique = true, length = 64)
    private String referenceCode;

    @Column(name = "status", nullable = false, length = 30)
    @Builder.Default
    private String status = "ACTIVE";

    @Column(name = "amount", precision = 15, scale = 2)
    @Builder.Default
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;

    @Column(name = "effective_date")
    @Builder.Default
    private Instant effectiveDate = Instant.now();
}
