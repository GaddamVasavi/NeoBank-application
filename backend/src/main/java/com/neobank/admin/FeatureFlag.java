package com.neobank.admin;
import com.neobank.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
@Entity @Table(name = "feature_flags") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class FeatureFlag extends BaseEntity {
    @Column(name = "flag_key", nullable = false, unique = true, length = 80) private String flagKey;
    @Column(name = "description", length = 255) private String description;
    @Column(name = "is_enabled", nullable = false) @Builder.Default private boolean enabled = false;
    @Column(name = "rollout_percentage") @Builder.Default private int rolloutPercentage = 100;
}
