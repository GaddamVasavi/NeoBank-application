package com.neobank.auditstream;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RegulatoryEvidencePackageRepository extends JpaRepository<RegulatoryEvidencePackage, UUID> {
    List<RegulatoryEvidencePackage> findByUserId(UUID userId);
    Optional<RegulatoryEvidencePackage> findByCoreReference(String ref);
    List<RegulatoryEvidencePackage> findByProcessingStatus(String status);
}
