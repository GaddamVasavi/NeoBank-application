package com.neobank.custody;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AssetCustodyAccountRepository extends JpaRepository<AssetCustodyAccount, UUID> {
    List<AssetCustodyAccount> findByUserId(UUID userId);
    Optional<AssetCustodyAccount> findBySettlementRef(String ref);
    List<AssetCustodyAccount> findByLifecycleStatus(String status);
}
