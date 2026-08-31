package com.neobank.custody;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SubCustodianNetworkNodeRepository extends JpaRepository<SubCustodianNetworkNode, UUID> {
    List<SubCustodianNetworkNode> findByUserId(UUID userId);
    Optional<SubCustodianNetworkNode> findBySettlementRef(String ref);
    List<SubCustodianNetworkNode> findByLifecycleStatus(String status);
}
