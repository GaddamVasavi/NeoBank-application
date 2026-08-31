package com.neobank.user;

import com.neobank.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "customer_profiles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfile extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "first_name", nullable = false, length = 60)
    private String firstName;

    @Column(name = "middle_name", length = 60)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 20)
    private Gender gender;

    @Column(name = "tax_id", length = 50)
    private String taxId;

    @Column(name = "nationality", length = 60)
    @Builder.Default
    private String nationality = "US";

    @Column(name = "avatar_url", length = 500)
    private String avatarUrl;

    @Column(name = "occupation", length = 100)
    private String occupation;

    @Column(name = "annual_income", precision = 15, scale = 2)
    private BigDecimal annualIncome;

    @Column(name = "kyc_status", nullable = false, length = 30)
    @Builder.Default
    private String kycStatus = "UNVERIFIED";

    @Column(name = "risk_score")
    @Builder.Default
    private Integer riskScore = 10;

    public String getFullName() {
        if (middleName != null && !middleName.isBlank()) {
            return firstName + " " + middleName + " " + lastName;
        }
        return firstName + " " + lastName;
    }
}
