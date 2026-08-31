package com.neobank.fxrates;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface HistoricFxVolatilityRecordRepository extends JpaRepository<HistoricFxVolatilityRecord, UUID> {
    List<HistoricFxVolatilityRecord> findByUserId(UUID userId);
    Optional<HistoricFxVolatilityRecord> findByRegistryKey(String key);
    List<HistoricFxVolatilityRecord> findByDeliveryStatus(String status);
}
