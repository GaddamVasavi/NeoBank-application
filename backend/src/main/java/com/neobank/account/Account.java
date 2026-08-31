package com.neobank.account;

import com.neobank.common.BaseEntity;
import com.neobank.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "account_number", nullable = false, unique = true, length = 20)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false, length = 30)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    @Builder.Default
    private AccountStatus status = AccountStatus.ACTIVE;

    @Column(name = "currency", nullable = false, length = 10)
    @Builder.Default
    private String currency = "USD";

    @Column(name = "balance", nullable = false, precision = 15, scale = 2)
    @Builder.Default
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "available_balance", nullable = false, precision = 15, scale = 2)
    @Builder.Default
    private BigDecimal availableBalance = BigDecimal.ZERO;

    @Column(name = "interest_rate", precision = 5, scale = 2)
    @Builder.Default
    private BigDecimal interestRate = BigDecimal.ZERO;

    @Column(name = "daily_transfer_limit", precision = 15, scale = 2)
    @Builder.Default
    private BigDecimal dailyTransferLimit = new BigDecimal("10000.00");

    @Column(name = "single_transfer_limit", precision = 15, scale = 2)
    @Builder.Default
    private BigDecimal singleTransferLimit = new BigDecimal("5000.00");

    @Column(name = "routing_number", length = 20)
    @Builder.Default
    private String routingNumber = "021000021";

    @Column(name = "nickname", length = 60)
    private String nickname;

    @Column(name = "opened_at", nullable = false)
    @Builder.Default
    private Instant openedAt = Instant.now();

    @Column(name = "closed_at")
    private Instant closedAt;
}
