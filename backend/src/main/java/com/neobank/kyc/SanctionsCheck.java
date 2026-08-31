package com.neobank.kyc;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.time.Instant;
@Entity @Table(name = "sanctions_checks") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class SanctionsCheck extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "matched_entity_name", length = 150) private String matchedEntityName;
    @Column(name = "watch_list_source", length = 60) @Builder.Default private String watchListSource = "OFAC_SDN";
    @Column(name = "match_score_percent", precision = 5, scale = 2) @Builder.Default private double matchScorePercent = 0.0;
    @Column(name = "status", nullable = false, length = 30) @Builder.Default private String status = "CLEARED";
    @Column(name = "screened_at", nullable = false) @Builder.Default private Instant screenedAt = Instant.now();
}
