package com.neobank.transfer;
import jakarta.validation.constraints.DecimalMin; import jakarta.validation.constraints.NotNull; import lombok.Data;
import java.math.BigDecimal; import java.util.UUID;
@Data
public class TransferRequest {
    @NotNull(message = "Source account is required") private UUID sourceAccountId;
    private UUID destinationAccountId;
    private String destinationAccountNumber;
    private UUID beneficiaryId;
    @NotNull(message = "Amount is required") @DecimalMin(value = "0.01", message = "Amount must be greater than 0") private BigDecimal amount;
    private TransferType transferType = TransferType.INTERNAL_OWN_ACCOUNT;
    private String note;
    private String idempotencyKey;
}
