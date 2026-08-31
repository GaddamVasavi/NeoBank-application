package com.finverse.tenant;
import jakarta.persistence.*; import lombok.*;
import java.time.Instant; import java.util.UUID;
@Entity @Table(name = "tenants") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Tenant {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID id;
    @Column(nullable = false, unique = true, length = 100) private String name;
    @Column(nullable = false, unique = true, length = 50) private String slug;
    @Column(nullable = false, length = 30) @Builder.Default private String status = "ACTIVE";
    @Column(nullable = false, length = 50) @Builder.Default private String planTier = "PROFESSIONAL";
    @Column(name = "created_at", nullable = false) @Builder.Default private Instant createdAt = Instant.now();
}
