package com.neobank.card;
import com.neobank.account.Account; import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.math.BigDecimal; import java.time.Instant;
@Entity @Table(name = "cards") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Card extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "account_id", nullable = false) private Account account;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "card_number", nullable = false, unique = true, length = 19) private String cardNumber;
    @Column(name = "cardholder_name", nullable = false, length = 100) private String cardholderName;
    @Enumerated(EnumType.STRING) @Column(name = "card_type", nullable = false, length = 20) private CardType cardType;
    @Column(name = "card_network", nullable = false, length = 20) @Builder.Default private String cardNetwork = "VISA";
    @Enumerated(EnumType.STRING) @Column(name = "status", nullable = false, length = 20) @Builder.Default private CardStatus status = CardStatus.ACTIVE;
    @Column(name = "expiry_month", nullable = false) private int expiryMonth;
    @Column(name = "expiry_year", nullable = false) private int expiryYear;
    @Column(name = "cvv_hash", nullable = false, length = 255) private String cvvHash;
    @Column(name = "pin_hash", length = 255) private String pinHash;
    @Column(name = "daily_limit", precision = 15, scale = 2) @Builder.Default private BigDecimal dailyLimit = new BigDecimal("2500.00");
    @Column(name = "monthly_limit", precision = 15, scale = 2) @Builder.Default private BigDecimal monthlyLimit = new BigDecimal("15000.00");
    @Column(name = "online_payments_enabled", nullable = false) @Builder.Default private boolean onlinePaymentsEnabled = true;
    @Column(name = "international_payments_enabled", nullable = false) @Builder.Default private boolean internationalPaymentsEnabled = false;
    @Column(name = "contactless_enabled", nullable = false) @Builder.Default private boolean contactlessEnabled = true;
    @Column(name = "atm_withdrawals_enabled", nullable = false) @Builder.Default private boolean atmWithdrawalsEnabled = true;
    @Column(name = "is_virtual", nullable = false) @Builder.Default private boolean virtual = false;
    @Column(name = "frozen_at") private Instant frozenAt;
}
