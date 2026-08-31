package com.neobank.auditcompliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RegulatoryWhistleblowerLogRepository extends JpaRepository<RegulatoryWhistleblowerLog, UUID> {
    List<RegulatoryWhistleblowerLog> findByUserId(UUID userId);
    Optional<RegulatoryWhistleblowerLog> findByClearingKey(String key);
    List<RegulatoryWhistleblowerLog> findByAuditStatus(String status);
}
