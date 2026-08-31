package com.neobank.transaction;

import com.neobank.account.Account;
import com.neobank.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "reference_number", nullable = false, unique = true, length = 36)
    private String referenceNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false, length = 30)
    private TransactionType transactionType;

    @Column(name = "category", nullable = false, length = 50)
    @Builder.Default
    private String category = "GENERAL";

    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "fee", precision = 15, scale = 2)
    @Builder.Default
    private BigDecimal fee = BigDecimal.ZERO;

    @Column(name = "currency", nullable = false, length = 10)
    @Builder.Default
    private String currency = "USD";

    @Column(name = "balance_after", nullable = false, precision = 15, scale = 2)
    private BigDecimal balanceAfter;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    @Builder.Default
    private TransactionStatus status = TransactionStatus.COMPLETED;

    @Column(name = "counterparty_account", length = 34)
    private String counterpartyAccount;

    @Column(name = "counterparty_name", length = 100)
    private String counterpartyName;

    @Column(name = "counterparty_bank", length = 100)
    private String counterpartyBank;

    @Column(name = "transaction_date", nullable = false)
    @Builder.Default
    private Instant transactionDate = Instant.now();
}
