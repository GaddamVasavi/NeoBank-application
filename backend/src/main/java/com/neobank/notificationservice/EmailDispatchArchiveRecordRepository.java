package com.neobank.notificationservice;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EmailDispatchArchiveRecordRepository extends JpaRepository<EmailDispatchArchiveRecord, UUID> {
    List<EmailDispatchArchiveRecord> findByUserId(UUID userId);
    Optional<EmailDispatchArchiveRecord> findByRegistryKey(String key);
    List<EmailDispatchArchiveRecord> findByDeliveryStatus(String status);
}
