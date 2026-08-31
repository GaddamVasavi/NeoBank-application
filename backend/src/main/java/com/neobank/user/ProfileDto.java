package com.neobank.user;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.LocalDate; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ProfileDto {
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String nationality;
    private String avatarUrl;
    private String occupation;
    private BigDecimal annualIncome;
    private String kycStatus;
    private Integer riskScore;
}
