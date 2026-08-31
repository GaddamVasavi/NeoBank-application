package com.neobank.operations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EndOfDaySettlementJobLogRepository extends JpaRepository<EndOfDaySettlementJobLog, UUID> {
    List<EndOfDaySettlementJobLog> findByUserId(UUID userId);
    Optional<EndOfDaySettlementJobLog> findByTrackingCode(String code);
    List<EndOfDaySettlementJobLog> findByStateFlag(String stateFlag);
}
