package com.neobank.transfer;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class SepaInstantPaymentDto {
    private UUID id; private UUID sourceAccountId; private String trackingNumber; private String status; private BigDecimal amount; private String currency; private String counterpartyInfo; private Instant processedAt;
}
