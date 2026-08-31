package com.neobank.user;

import com.neobank.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type", nullable = false, length = 30)
    @Builder.Default
    private AddressType addressType = AddressType.RESIDENTIAL;

    @Column(name = "street_line1", nullable = false, length = 150)
    private String streetLine1;

    @Column(name = "street_line2", length = 150)
    private String streetLine2;

    @Column(name = "city", nullable = false, length = 80)
    private String city;

    @Column(name = "state_province", nullable = false, length = 80)
    private String stateProvince;

    @Column(name = "postal_code", nullable = false, length = 20)
    private String postalCode;

    @Column(name = "country", nullable = false, length = 60)
    @Builder.Default
    private String country = "United States";

    @Column(name = "is_primary", nullable = false)
    @Builder.Default
    private boolean primary = true;
}
