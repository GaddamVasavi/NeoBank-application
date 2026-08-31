package com.neobank.auth;
import jakarta.validation.constraints.Email; import jakarta.validation.constraints.NotBlank; import jakarta.validation.constraints.Size; import lombok.Data;
import java.math.BigDecimal; import java.time.LocalDate;
@Data
public class RegisterRequest {
    @NotBlank(message = "Username is required") @Size(min = 3, max = 50) private String username;
    @NotBlank(message = "Email is required") @Email private String email;
    @NotBlank(message = "Password is required") @Size(min = 8, max = 100) private String password;
    @NotBlank(message = "First name is required") private String firstName;
    private String middleName;
    @NotBlank(message = "Last name is required") private String lastName;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String occupation;
    private BigDecimal annualIncome;
}
