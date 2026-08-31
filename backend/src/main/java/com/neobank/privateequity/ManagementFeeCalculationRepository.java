package com.neobank.privateequity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ManagementFeeCalculationRepository extends JpaRepository<ManagementFeeCalculation, UUID> {
    List<ManagementFeeCalculation> findByUserId(UUID userId);
    Optional<ManagementFeeCalculation> findByProtocolReference(String ref);
    List<ManagementFeeCalculation> findByOperationalState(String state);
}
