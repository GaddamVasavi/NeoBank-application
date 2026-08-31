package com.neobank.compliance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FatcaDeclarationCertificateRepository extends JpaRepository<FatcaDeclarationCertificate, UUID> {
    List<FatcaDeclarationCertificate> findByUserId(UUID userId);
    Optional<FatcaDeclarationCertificate> findByIdentifierCode(String code);
    List<FatcaDeclarationCertificate> findByStatus(String status);
}
