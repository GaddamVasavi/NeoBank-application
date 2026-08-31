package com.neobank.kyc;

import com.neobank.common.BaseEntity;
import com.neobank.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/** Interpol, FBI, and international watchlist match audit trail */
@Entity
@Table(name = "watchlistmatchaudits")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WatchlistMatchAudit extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "record_key", nullable = false, unique = true, length = 64)
    private String recordKey;

    @Column(name = "status", nullable = false, length = 30)
    @Builder.Default
    private String status = "ACTIVE";

    @Column(name = "metric_value", precision = 15, scale = 2)
    @Builder.Default
    private BigDecimal metricValue = BigDecimal.ZERO;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "payload_data", columnDefinition = "TEXT")
    private String payloadData;

    @Column(name = "is_valid", nullable = false)
    @Builder.Default
    private boolean valid = true;

    @Column(name = "timestamp_recorded")
    @Builder.Default
    private Instant timestampRecorded = Instant.now();
}
