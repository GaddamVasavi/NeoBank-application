package com.neobank.account;

import com.neobank.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "account_limits")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountLimit extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false, unique = true)
    private Account account;

    @Column(name = "daily_transfer_limit", precision = 15, scale = 2)
    @Builder.Default
    private BigDecimal dailyTransferLimit = new BigDecimal("10000.00");

    @Column(name = "daily_spent_amount", precision = 15, scale = 2)
    @Builder.Default
    private BigDecimal dailySpentAmount = BigDecimal.ZERO;

    @Column(name = "last_spent_date")
    @Builder.Default
    private LocalDate lastSpentDate = LocalDate.now();

    public boolean canSpend(BigDecimal amount) {
        LocalDate today = LocalDate.now();
        BigDecimal currentSpent = today.equals(lastSpentDate) ? dailySpentAmount : BigDecimal.ZERO;
        return currentSpent.add(amount).compareTo(dailyTransferLimit) <= 0;
    }

    public void recordSpend(BigDecimal amount) {
        LocalDate today = LocalDate.now();
        if (!today.equals(lastSpentDate)) {
            dailySpentAmount = amount;
            lastSpentDate = today;
        } else {
            dailySpentAmount = dailySpentAmount.add(amount);
        }
    }
}
