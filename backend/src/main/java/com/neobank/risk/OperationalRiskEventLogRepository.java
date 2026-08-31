package com.neobank.risk;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface OperationalRiskEventLogRepository extends JpaRepository<OperationalRiskEventLog, UUID> {
    List<OperationalRiskEventLog> findByUserId(UUID userId);
    Optional<OperationalRiskEventLog> findByTrackingCode(String code);
    List<OperationalRiskEventLog> findByStateFlag(String stateFlag);
}
