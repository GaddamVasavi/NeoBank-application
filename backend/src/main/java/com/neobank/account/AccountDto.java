package com.neobank.account;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountDto {
    private UUID id;
    private String accountNumber;
    private AccountType accountType;
    private AccountStatus status;
    private String currency;
    private BigDecimal balance;
    private BigDecimal availableBalance;
    private BigDecimal interestRate;
    private BigDecimal dailyTransferLimit;
    private BigDecimal singleTransferLimit;
    private String routingNumber;
    private String nickname;
    private Instant openedAt;
}
