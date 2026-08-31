package com.neobank.settlementgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FedwireHighValueMessageHeaderRepository extends JpaRepository<FedwireHighValueMessageHeader, UUID> {
    List<FedwireHighValueMessageHeader> findByUserId(UUID userId);
    Optional<FedwireHighValueMessageHeader> findByGatewayReference(String ref);
    List<FedwireHighValueMessageHeader> findBySettlementState(String state);
}
