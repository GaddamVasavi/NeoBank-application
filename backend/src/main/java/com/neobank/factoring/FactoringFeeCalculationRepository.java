package com.neobank.factoring;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FactoringFeeCalculationRepository extends JpaRepository<FactoringFeeCalculation, UUID> {
    List<FactoringFeeCalculation> findByUserId(UUID userId);
    Optional<FactoringFeeCalculation> findByDossierReference(String ref);
    List<FactoringFeeCalculation> findByOperationalStatus(String status);
}
