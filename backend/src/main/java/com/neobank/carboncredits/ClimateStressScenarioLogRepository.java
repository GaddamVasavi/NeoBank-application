package com.neobank.carboncredits;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ClimateStressScenarioLogRepository extends JpaRepository<ClimateStressScenarioLog, UUID> {
    List<ClimateStressScenarioLog> findByUserId(UUID userId);
    Optional<ClimateStressScenarioLog> findByProtocolReference(String ref);
    List<ClimateStressScenarioLog> findByOperationalState(String state);
}
