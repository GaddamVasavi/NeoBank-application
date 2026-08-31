package com.neobank.support;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CannedResponseTemplateRepository extends JpaRepository<CannedResponseTemplate, UUID> {
    List<CannedResponseTemplate> findByUserId(UUID userId);
    Optional<CannedResponseTemplate> findByRecordKey(String recordKey);
    List<CannedResponseTemplate> findByStatus(String status);
}
