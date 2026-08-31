package com.neobank.fraud;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.time.Instant; import java.util.UUID;
@Entity @Table(name = "fraud_cases") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class FraudCase extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "transaction_id") private UUID transactionId;
    @Column(name = "case_reference", nullable = false, unique = true, length = 36) private String caseReference;
    @Column(name = "risk_score", nullable = false) private int riskScore;
    @Column(name = "trigger_reason", nullable = false) private String triggerReason;
    @Column(name = "status", nullable = false, length = 30) @Builder.Default private String status = "OPEN";
    @Column(name = "assigned_to") private UUID assignedTo;
    @Column(name = "resolution_notes", columnDefinition = "TEXT") private String resolutionNotes;
    @Column(name = "resolved_at") private Instant resolvedAt;
}
