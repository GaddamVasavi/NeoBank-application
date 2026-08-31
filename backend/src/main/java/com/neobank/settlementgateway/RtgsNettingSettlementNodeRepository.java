package com.neobank.settlementgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RtgsNettingSettlementNodeRepository extends JpaRepository<RtgsNettingSettlementNode, UUID> {
    List<RtgsNettingSettlementNode> findByUserId(UUID userId);
    Optional<RtgsNettingSettlementNode> findByGatewayReference(String ref);
    List<RtgsNettingSettlementNode> findBySettlementState(String state);
}
