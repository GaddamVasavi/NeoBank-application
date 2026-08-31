package com.neobank.admin;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SecurityIncidentLogRepository extends JpaRepository<SecurityIncidentLog, UUID> {
    List<SecurityIncidentLog> findByUserId(UUID userId);
    Optional<SecurityIncidentLog> findByRecordKey(String recordKey);
    List<SecurityIncidentLog> findByStatus(String status);
}
