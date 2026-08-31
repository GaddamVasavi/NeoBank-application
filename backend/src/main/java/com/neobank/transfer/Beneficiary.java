package com.neobank.transfer;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
@Entity @Table(name = "beneficiaries") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Beneficiary extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "name", nullable = false, length = 100) private String name;
    @Column(name = "nickname", length = 60) private String nickname;
    @Column(name = "account_number", nullable = false, length = 34) private String accountNumber;
    @Column(name = "bank_name", nullable = false, length = 100) @Builder.Default private String bankName = "NeoBank";
    @Column(name = "routing_number", length = 30) private String routingNumber;
    @Column(name = "email", length = 120) private String email;
    @Column(name = "is_internal", nullable = false) @Builder.Default private boolean internal = true;
    @Column(name = "is_favorite", nullable = false) @Builder.Default private boolean favorite = false;
}
