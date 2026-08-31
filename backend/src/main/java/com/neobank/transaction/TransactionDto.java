package com.neobank.transaction;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class TransactionDto {
    private UUID id;
    private UUID accountId;
    private String referenceNumber;
    private TransactionType transactionType;
    private String category;
    private BigDecimal amount;
    private BigDecimal fee;
    private String currency;
    private BigDecimal balanceAfter;
    private String description;
    private TransactionStatus status;
    private String counterpartyAccount;
    private String counterpartyName;
    private Instant transactionDate;
}
