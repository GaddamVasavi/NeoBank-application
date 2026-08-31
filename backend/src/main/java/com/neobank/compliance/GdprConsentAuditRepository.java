package com.neobank.compliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface GdprConsentAuditRepository extends JpaRepository<GdprConsentAudit, UUID> {
    List<GdprConsentAudit> findByUserId(UUID userId);
    Optional<GdprConsentAudit> findByIdentifierCode(String code);
    List<GdprConsentAudit> findByStatus(String status);
}
