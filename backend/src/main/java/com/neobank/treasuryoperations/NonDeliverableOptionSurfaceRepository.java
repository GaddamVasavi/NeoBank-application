package com.neobank.treasuryoperations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface NonDeliverableOptionSurfaceRepository extends JpaRepository<NonDeliverableOptionSurface, UUID> {
    List<NonDeliverableOptionSurface> findByUserId(UUID userId);
    Optional<NonDeliverableOptionSurface> findByClearingIdentifier(String id);
    List<NonDeliverableOptionSurface> findBySettlementStatus(String status);
}
