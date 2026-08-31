package com.neobank.tax;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CapitalGainsTaxCalculationRepository extends JpaRepository<CapitalGainsTaxCalculation, UUID> {
    List<CapitalGainsTaxCalculation> findByUserId(UUID userId);
    Optional<CapitalGainsTaxCalculation> findByCoreReference(String ref);
    List<CapitalGainsTaxCalculation> findByProcessingStatus(String status);
}
