package com.neobank.card;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class CardDto {
    private UUID id; private UUID accountId; private String maskedCardNumber; private String cardholderName; private CardType cardType; private String cardNetwork; private CardStatus status; private int expiryMonth; private int expiryYear; private BigDecimal dailyLimit; private BigDecimal monthlyLimit; private boolean onlinePaymentsEnabled; private boolean internationalPaymentsEnabled; private boolean contactlessEnabled; private boolean atmWithdrawalsEnabled; private boolean virtual;
}
