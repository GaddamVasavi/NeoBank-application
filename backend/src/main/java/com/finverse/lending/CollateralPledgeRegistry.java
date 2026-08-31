package com.finverse.lending;

import com.finverse.common.BaseEntity;
import com.finverse.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * Enterprise FinVerse Entity: CollateralPledgeRegistry
 * Specification: Real estate, inventory, and equipment collateral lien registry
 */
@Entity
@Table(name = "collateralpledgeregistrys", indexes = {
    @Index(name = "idx_collateralpledgeregistry_tenant", columnList = "tenant_id"),
    @Index(name = "idx_collateralpledgeregistry_ref", columnList = "system_reference")
})
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class CollateralPledgeRegistry extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Size(min = 4, max = 64)
    @Column(name = "system_reference", nullable = false, unique = true, length = 64)
    private String systemReference;

    @NotNull
    @Column(name = "operational_status", nullable = false, length = 30)
    @Builder.Default
    private String operationalStatus = "ACTIVE";

    @Column(name = "certified_quantum", precision = 18, scale = 4)
    @Builder.Default
    private BigDecimal certifiedQuantum = BigDecimal.ZERO;

    @Column(name = "iso_currency", length = 10)
    @Builder.Default
    private String isoCurrency = "USD";

    @Column(name = "compliance_memo", columnDefinition = "TEXT")
    private String complianceMemo;

    @Column(name = "is_audited_record", nullable = false)
    @Builder.Default
    private boolean auditedRecord = true;

    @Column(name = "timestamp_logged")
    @Builder.Default
    private Instant timestampLogged = Instant.now();
}
