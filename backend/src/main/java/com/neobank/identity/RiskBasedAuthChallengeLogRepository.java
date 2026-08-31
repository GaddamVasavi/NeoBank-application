package com.neobank.identity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RiskBasedAuthChallengeLogRepository extends JpaRepository<RiskBasedAuthChallengeLog, UUID> {
    List<RiskBasedAuthChallengeLog> findByUserId(UUID userId);
    Optional<RiskBasedAuthChallengeLog> findByRegistryKey(String key);
    List<RiskBasedAuthChallengeLog> findByDeliveryStatus(String status);
}
