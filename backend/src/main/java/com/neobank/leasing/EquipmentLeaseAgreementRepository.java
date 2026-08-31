package com.neobank.leasing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EquipmentLeaseAgreementRepository extends JpaRepository<EquipmentLeaseAgreement, UUID> {
    List<EquipmentLeaseAgreement> findByUserId(UUID userId);
    Optional<EquipmentLeaseAgreement> findByDossierReference(String ref);
    List<EquipmentLeaseAgreement> findByOperationalStatus(String status);
}
