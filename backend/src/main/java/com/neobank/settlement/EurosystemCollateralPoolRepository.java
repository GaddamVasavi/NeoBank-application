package com.neobank.settlement;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EurosystemCollateralPoolRepository extends JpaRepository<EurosystemCollateralPool, UUID> {
    List<EurosystemCollateralPool> findByUserId(UUID userId);
    Optional<EurosystemCollateralPool> findBySettlementRef(String ref);
    List<EurosystemCollateralPool> findByLifecycleStatus(String status);
}
