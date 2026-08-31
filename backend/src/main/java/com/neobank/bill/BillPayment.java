package com.neobank.bill;
import com.neobank.account.Account; import com.neobank.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant;
@Entity @Table(name = "bill_payments") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class BillPayment extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "account_id", nullable = false) private Account account;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "biller_id", nullable = false) private Biller biller;
    @Column(name = "reference_id", nullable = false, unique = true, length = 36) private String referenceId;
    @Column(name = "consumer_number", nullable = false, length = 60) private String consumerNumber;
    @Column(name = "amount", nullable = false, precision = 15, scale = 2) private BigDecimal amount;
    @Column(name = "currency", nullable = false, length = 10) @Builder.Default private String currency = "USD";
    @Column(name = "status", nullable = false, length = 30) @Builder.Default private String status = "COMPLETED";
    @Column(name = "paid_at", nullable = false) @Builder.Default private Instant paidAt = Instant.now();
}
