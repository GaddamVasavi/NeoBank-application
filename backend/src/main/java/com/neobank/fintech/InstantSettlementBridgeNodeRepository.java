package com.neobank.fintech;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InstantSettlementBridgeNodeRepository extends JpaRepository<InstantSettlementBridgeNode, UUID> {
    List<InstantSettlementBridgeNode> findByUserId(UUID userId);
    Optional<InstantSettlementBridgeNode> findByInstitutionalRef(String ref);
    List<InstantSettlementBridgeNode> findByExecutionStatus(String status);
}
