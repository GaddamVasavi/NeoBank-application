package com.neobank.user;
import jakarta.validation.constraints.NotBlank; import jakarta.validation.constraints.Size; import lombok.Data;
import java.math.BigDecimal; import java.time.LocalDate;
@Data
public class UpdateProfileRequest {
    @NotBlank(message = "First name is required")
    @Size(max = 60) private String firstName;
    @Size(max = 60) private String middleName;
    @NotBlank(message = "Last name is required")
    @Size(max = 60) private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String nationality;
    private String occupation;
    private BigDecimal annualIncome;
    private String avatarUrl;
}
