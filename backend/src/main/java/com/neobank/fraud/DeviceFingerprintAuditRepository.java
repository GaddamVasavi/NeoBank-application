package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DeviceFingerprintAuditRepository extends JpaRepository<DeviceFingerprintAudit, UUID> {
    List<DeviceFingerprintAudit> findByUserId(UUID userId);
    Optional<DeviceFingerprintAudit> findByRecordKey(String recordKey);
    List<DeviceFingerprintAudit> findByStatus(String status);
}
