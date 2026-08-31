package com.neobank.leasing;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** Finance lease capitalized value and bargain purchase option */
@Entity @Table(name = "capitalleaseobligations") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class CapitalLeaseObligation extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "dossier_reference", nullable = false, unique = true, length = 64) private String dossierReference;
    @Column(name = "operational_status", nullable = false, length = 30) @Builder.Default private String operationalStatus = "ACTIVE";
    @Column(name = "financial_metric", precision = 18, scale = 4) @Builder.Default private BigDecimal financialMetric = BigDecimal.ZERO;
    @Column(name = "currency_iso", length = 10) @Builder.Default private String currencyIso = "USD";
    @Column(name = "operational_details", columnDefinition = "TEXT") private String operationalDetails;
    @Column(name = "is_active_flag", nullable = false) @Builder.Default private boolean activeFlag = true;
    @Column(name = "logged_at") @Builder.Default private Instant loggedAt = Instant.now();
}
