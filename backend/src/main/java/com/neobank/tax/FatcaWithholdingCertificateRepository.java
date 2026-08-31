package com.neobank.tax;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FatcaWithholdingCertificateRepository extends JpaRepository<FatcaWithholdingCertificate, UUID> {
    List<FatcaWithholdingCertificate> findByUserId(UUID userId);
    Optional<FatcaWithholdingCertificate> findByCoreReference(String ref);
    List<FatcaWithholdingCertificate> findByProcessingStatus(String status);
}
