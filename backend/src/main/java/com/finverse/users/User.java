package com.finverse.users;
import com.finverse.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
import java.time.Instant; import java.util.UUID;
@Entity @Table(name = "users") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class User extends BaseEntity {
    @Column(nullable = false, unique = true, length = 100) private String email;
    @Column(nullable = false, length = 255) private String passwordHash;
    @Column(nullable = false, length = 50) private String firstName;
    @Column(nullable = false, length = 50) private String lastName;
    @Column(nullable = false, length = 30) @Builder.Default private String role = "CUSTOMER";
    @Column(nullable = false) @Builder.Default private boolean active = true;
    @Column(name = "mfa_enabled", nullable = false) @Builder.Default private boolean mfaEnabled = false;
}
