package com.neobank.transaction;

import com.neobank.account.Account;
import com.neobank.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "double_entry_ledger")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoubleEntryLedger extends BaseEntity {
    @Column(name = "entry_reference", nullable = false, length = 36)
    private String entryReference;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "debit_account_id")
    private Account debitAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_account_id")
    private Account creditAccount;

    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false, length = 10)
    @Builder.Default
    private String currency = "USD";

    @Column(name = "narration", nullable = false, length = 255)
    private String narration;

    @Column(name = "posted_at", nullable = false)
    @Builder.Default
    private Instant postedAt = Instant.now();
}
