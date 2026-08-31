package com.neobank.support;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SupportAttachmentRecordRepository extends JpaRepository<SupportAttachmentRecord, UUID> {
    List<SupportAttachmentRecord> findByUserId(UUID userId);
    Optional<SupportAttachmentRecord> findByRecordKey(String recordKey);
    List<SupportAttachmentRecord> findByStatus(String status);
}
