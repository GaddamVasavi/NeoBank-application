package com.neobank.privateequity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SecondaryLpInterestSaleRepository extends JpaRepository<SecondaryLpInterestSale, UUID> {
    List<SecondaryLpInterestSale> findByUserId(UUID userId);
    Optional<SecondaryLpInterestSale> findByProtocolReference(String ref);
    List<SecondaryLpInterestSale> findByOperationalState(String state);
}
