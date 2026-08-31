package com.neobank.auditstream;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CryptographicAuditSealRepository extends JpaRepository<CryptographicAuditSeal, UUID> {
    List<CryptographicAuditSeal> findByUserId(UUID userId);
    Optional<CryptographicAuditSeal> findByCoreReference(String ref);
    List<CryptographicAuditSeal> findByProcessingStatus(String status);
}
