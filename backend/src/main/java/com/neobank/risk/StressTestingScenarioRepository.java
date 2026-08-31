package com.neobank.risk;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface StressTestingScenarioRepository extends JpaRepository<StressTestingScenario, UUID> {
    List<StressTestingScenario> findByUserId(UUID userId);
    Optional<StressTestingScenario> findByTrackingCode(String code);
    List<StressTestingScenario> findByStateFlag(String stateFlag);
}
