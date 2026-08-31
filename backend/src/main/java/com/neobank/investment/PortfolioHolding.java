package com.neobank.investment;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
/** Equity, ETF, and fixed income portfolio asset holdings */
@Entity @Table(name = "portfolioholdings") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class PortfolioHolding extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") private User user;
    @Column(name = "identifier_code", nullable = false, unique = true, length = 64) private String identifierCode;
    @Column(name = "status", nullable = false, length = 30) @Builder.Default private String status = "ACTIVE";
    @Column(name = "nominal_amount", precision = 18, scale = 4) @Builder.Default private BigDecimal nominalAmount = BigDecimal.ZERO;
    @Column(name = "currency", length = 10) @Builder.Default private String currency = "USD";
    @Column(name = "specification_notes", columnDefinition = "TEXT") private String specificationNotes;
    @Column(name = "is_active", nullable = false) @Builder.Default private boolean active = true;
    @Column(name = "executed_at") @Builder.Default private Instant executedAt = Instant.now();
}
