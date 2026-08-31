package com.neobank.card;
import com.neobank.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
import java.time.Instant;
@Entity @Table(name = "virtual_card_tokens") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class VirtualCardToken extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "card_id", nullable = false) private Card card;
    @Column(name = "token_reference", nullable = false, unique = true, length = 64) private String tokenReference;
    @Column(name = "device_binding", length = 100) private String deviceBinding;
    @Column(name = "is_active", nullable = false) @Builder.Default private boolean active = true;
    @Column(name = "expires_at", nullable = false) private Instant expiresAt;
}
