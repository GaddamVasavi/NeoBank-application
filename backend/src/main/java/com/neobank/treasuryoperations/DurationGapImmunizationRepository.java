package com.neobank.treasuryoperations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DurationGapImmunizationRepository extends JpaRepository<DurationGapImmunization, UUID> {
    List<DurationGapImmunization> findByUserId(UUID userId);
    Optional<DurationGapImmunization> findByClearingIdentifier(String id);
    List<DurationGapImmunization> findBySettlementStatus(String status);
}
