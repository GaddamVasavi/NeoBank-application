package com.neobank.insurance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PolicyUnderwritingRecordRepository extends JpaRepository<PolicyUnderwritingRecord, UUID> {
    List<PolicyUnderwritingRecord> findByUserId(UUID userId);
    Optional<PolicyUnderwritingRecord> findByDossierReference(String ref);
    List<PolicyUnderwritingRecord> findByOperationalStatus(String status);
}
