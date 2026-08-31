package com.neobank.marketing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MarketingConsentAuditRecordRepository extends JpaRepository<MarketingConsentAuditRecord, UUID> {
    List<MarketingConsentAuditRecord> findByUserId(UUID userId);
    Optional<MarketingConsentAuditRecord> findByTrackingCode(String code);
    List<MarketingConsentAuditRecord> findByStateFlag(String stateFlag);
}
