package com.neobank.auth;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
@Entity @Table(name = "password_histories") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class PasswordHistory extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "password_hash", nullable = false, length = 255) private String passwordHash;
}
