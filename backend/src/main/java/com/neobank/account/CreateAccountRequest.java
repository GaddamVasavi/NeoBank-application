package com.neobank.account;
import jakarta.validation.constraints.NotNull; import lombok.Data;
import java.math.BigDecimal;
@Data
public class CreateAccountRequest {
    @NotNull(message = "Account type is required")
    private AccountType accountType;
    private String currency = "USD";
    private String nickname;
    private BigDecimal initialDeposit = BigDecimal.ZERO;
}
