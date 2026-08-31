package com.neobank.transfer;
import com.neobank.account.Account; import com.neobank.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.LocalDate; import java.util.UUID;
@Entity @Table(name = "scheduled_transfers") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class ScheduledTransfer extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "source_account_id", nullable = false) private Account sourceAccount;
    @Column(name = "destination_account_number", nullable = false, length = 34) private String destinationAccountNumber;
    @Column(name = "amount", nullable = false, precision = 15, scale = 2) private BigDecimal amount;
    @Column(name = "execution_date", nullable = false) private LocalDate executionDate;
    @Column(name = "frequency", nullable = false, length = 20) @Builder.Default private String frequency = "ONE_TIME";
    @Column(name = "is_active", nullable = false) @Builder.Default private boolean active = true;
    @Column(name = "note", length = 255) private String note;
}
