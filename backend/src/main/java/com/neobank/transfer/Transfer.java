package com.neobank.transfer;
import com.neobank.account.Account; import com.neobank.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant;
@Entity @Table(name = "transfers") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Transfer extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "source_account_id", nullable = false) private Account sourceAccount;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "destination_account_id") private Account destinationAccount;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "beneficiary_id") private Beneficiary beneficiary;
    @Column(name = "reference_id", nullable = false, unique = true, length = 36) private String referenceId;
    @Column(name = "idempotency_key", length = 100) private String idempotencyKey;
    @Enumerated(EnumType.STRING) @Column(name = "transfer_type", nullable = false, length = 30) private TransferType transferType;
    @Column(name = "amount", nullable = false, precision = 15, scale = 2) private BigDecimal amount;
    @Column(name = "fee", precision = 15, scale = 2) @Builder.Default private BigDecimal fee = BigDecimal.ZERO;
    @Column(name = "currency", nullable = false, length = 10) @Builder.Default private String currency = "USD";
    @Enumerated(EnumType.STRING) @Column(name = "status", nullable = false, length = 30) @Builder.Default private TransferStatus status = TransferStatus.PENDING;
    @Column(name = "note", length = 255) private String note;
    @Column(name = "executed_at") private Instant executedAt;
}
