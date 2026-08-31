package com.neobank.kyc;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface WatchlistMatchAuditRepository extends JpaRepository<WatchlistMatchAudit, UUID> {
    List<WatchlistMatchAudit> findByUserId(UUID userId);
    Optional<WatchlistMatchAudit> findByRecordKey(String recordKey);
    List<WatchlistMatchAudit> findByStatus(String status);
}
