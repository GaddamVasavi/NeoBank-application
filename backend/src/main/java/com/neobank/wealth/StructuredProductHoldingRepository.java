package com.neobank.wealth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface StructuredProductHoldingRepository extends JpaRepository<StructuredProductHolding, UUID> {
    List<StructuredProductHolding> findByUserId(UUID userId);
    Optional<StructuredProductHolding> findByTrackingCode(String code);
    List<StructuredProductHolding> findByStateFlag(String stateFlag);
}
