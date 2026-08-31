package com.neobank.kyc;

import com.neobank.common.BaseEntity;
import com.neobank.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/** Liveness detection and facial recognition match confidence metrics */
@Entity
@Table(name = "biometricverificationlogs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BiometricVerificationLog extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "code_reference", nullable = false, unique = true, length = 64)
    private String codeReference;

    @Column(name = "status", nullable = false, length = 30)
    @Builder.Default
    private String status = "ACTIVE";

    @Column(name = "score_value", precision = 10, scale = 2)
    @Builder.Default
    private BigDecimal scoreValue = BigDecimal.ZERO;

    @Column(name = "metadata_payload", columnDefinition = "TEXT")
    private String metadataPayload;

    @Column(name = "verified_at")
    private Instant verifiedAt;
}
