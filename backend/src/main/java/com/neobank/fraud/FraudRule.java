package com.neobank.fraud;
import com.neobank.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal;
@Entity @Table(name = "fraud_rules") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class FraudRule extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true, length = 100) private String name;
    @Column(name = "description") private String description;
    @Column(name = "rule_type", nullable = false, length = 40) private String ruleType;
    @Column(name = "threshold_value", precision = 15, scale = 2) private BigDecimal thresholdValue;
    @Column(name = "action", nullable = false, length = 30) @Builder.Default private String action = "FLAG_REVIEW";
    @Column(name = "is_active") @Builder.Default private boolean active = true;
}
