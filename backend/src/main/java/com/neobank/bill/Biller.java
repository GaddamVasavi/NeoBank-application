package com.neobank.bill;
import com.neobank.common.BaseEntity; import jakarta.persistence.*; import lombok.*;
@Entity @Table(name = "billers") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Biller extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true, length = 100) private String name;
    @Column(name = "category", nullable = false, length = 50) private String category;
    @Column(name = "account_identifier_name", nullable = false, length = 60) @Builder.Default private String accountIdentifierName = "Account ID";
    @Column(name = "logo_url", length = 500) private String logoUrl;
}
