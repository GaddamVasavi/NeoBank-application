package com.neobank.auditcompliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BaselCapitalBufferRatioLogRepository extends JpaRepository<BaselCapitalBufferRatioLog, UUID> {
    List<BaselCapitalBufferRatioLog> findByUserId(UUID userId);
    Optional<BaselCapitalBufferRatioLog> findByClearingKey(String key);
    List<BaselCapitalBufferRatioLog> findByAuditStatus(String status);
}
