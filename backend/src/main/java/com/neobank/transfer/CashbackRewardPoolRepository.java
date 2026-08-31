package com.neobank.transfer;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CashbackRewardPoolRepository extends JpaRepository<CashbackRewardPool, UUID> {
    List<CashbackRewardPool> findBySourceAccountId(UUID accountId);
    Optional<CashbackRewardPool> findByTrackingNumber(String trackingNumber);
    List<CashbackRewardPool> findByStatus(String status);
}
