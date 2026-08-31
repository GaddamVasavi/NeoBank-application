package com.neobank.settlementgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ClearingHouseMarginPoolRepository extends JpaRepository<ClearingHouseMarginPool, UUID> {
    List<ClearingHouseMarginPool> findByUserId(UUID userId);
    Optional<ClearingHouseMarginPool> findByGatewayReference(String ref);
    List<ClearingHouseMarginPool> findBySettlementState(String state);
}
