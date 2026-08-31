package com.neobank.syndication;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface IntercreditorAgreementRecordRepository extends JpaRepository<IntercreditorAgreementRecord, UUID> {
    List<IntercreditorAgreementRecord> findByUserId(UUID userId);
    Optional<IntercreditorAgreementRecord> findByDossierReference(String ref);
    List<IntercreditorAgreementRecord> findByOperationalStatus(String status);
}
