package com.neobank.operations;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** SWIFT MT103, MT202, and ISO 20022 PACS.008 message audit archive */
@Entity @Table(name = "swiftmessageauditlogs") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class SwiftMessageAuditLog extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "tracking_code", nullable = false, unique = true, length = 64) private String trackingCode;
    @Column(name = "state_flag", nullable = false, length = 30) @Builder.Default private String stateFlag = "ACTIVE";
    @Column(name = "evaluation_amount", precision = 18, scale = 4) @Builder.Default private BigDecimal evaluationAmount = BigDecimal.ZERO;
    @Column(name = "denomination", length = 10) @Builder.Default private String denomination = "USD";
    @Column(name = "audit_narrative", columnDefinition = "TEXT") private String auditNarrative;
    @Column(name = "is_enabled", nullable = false) @Builder.Default private boolean enabled = true;
    @Column(name = "creation_timestamp") @Builder.Default private Instant creationTimestamp = Instant.now();
}
