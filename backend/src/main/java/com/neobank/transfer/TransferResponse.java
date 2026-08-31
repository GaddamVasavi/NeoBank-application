package com.neobank.transfer;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class TransferResponse {
    private UUID transferId;
    private String referenceId;
    private TransferStatus status;
    private BigDecimal amount;
    private BigDecimal fee;
    private String currency;
    private Instant timestamp;
    private String message;
}
