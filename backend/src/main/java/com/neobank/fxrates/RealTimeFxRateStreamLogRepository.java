package com.neobank.fxrates;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RealTimeFxRateStreamLogRepository extends JpaRepository<RealTimeFxRateStreamLog, UUID> {
    List<RealTimeFxRateStreamLog> findByUserId(UUID userId);
    Optional<RealTimeFxRateStreamLog> findByRegistryKey(String key);
    List<RealTimeFxRateStreamLog> findByDeliveryStatus(String status);
}
