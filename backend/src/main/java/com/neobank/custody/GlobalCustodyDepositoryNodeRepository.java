package com.neobank.custody;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface GlobalCustodyDepositoryNodeRepository extends JpaRepository<GlobalCustodyDepositoryNode, UUID> {
    List<GlobalCustodyDepositoryNode> findByUserId(UUID userId);
    Optional<GlobalCustodyDepositoryNode> findBySettlementRef(String ref);
    List<GlobalCustodyDepositoryNode> findByLifecycleStatus(String status);
}
