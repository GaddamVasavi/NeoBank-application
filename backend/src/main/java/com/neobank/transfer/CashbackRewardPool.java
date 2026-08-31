package com.neobank.transfer;

import com.neobank.account.Account;
import com.neobank.common.BaseEntity;
import com.neobank.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/** Merchant transaction rewards, cashback accruals, and loyalty tier disbursements */
@Entity
@Table(name = "cashbackrewardpools")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CashbackRewardPool extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_account_id", nullable = false)
    private Account sourceAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "tracking_number", nullable = false, unique = true, length = 64)
    private String trackingNumber;

    @Column(name = "status", nullable = false, length = 30)
    @Builder.Default
    private String status = "PENDING";

    @Column(name = "amount", precision = 15, scale = 2)
    @Builder.Default
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "currency", length = 10)
    @Builder.Default
    private String currency = "USD";

    @Column(name = "counterparty_info", columnDefinition = "TEXT")
    private String counterpartyInfo;

    @Column(name = "processed_at")
    private Instant processedAt;
}
