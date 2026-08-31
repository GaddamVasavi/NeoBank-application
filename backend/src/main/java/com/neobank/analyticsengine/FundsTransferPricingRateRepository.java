package com.neobank.analyticsengine;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FundsTransferPricingRateRepository extends JpaRepository<FundsTransferPricingRate, UUID> {
    List<FundsTransferPricingRate> findByUserId(UUID userId);
    Optional<FundsTransferPricingRate> findByCoreReference(String ref);
    List<FundsTransferPricingRate> findByProcessingStatus(String status);
}
