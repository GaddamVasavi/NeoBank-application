package com.neobank.admin;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AdminAccessLogRepository extends JpaRepository<AdminAccessLog, UUID> {
    List<AdminAccessLog> findByUserId(UUID userId);
    Optional<AdminAccessLog> findByRecordKey(String recordKey);
    List<AdminAccessLog> findByStatus(String status);
}
