package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FraudInvestigationDossierRepository extends JpaRepository<FraudInvestigationDossier, UUID> {
    List<FraudInvestigationDossier> findByUserId(UUID userId);
    Optional<FraudInvestigationDossier> findByRecordKey(String recordKey);
    List<FraudInvestigationDossier> findByStatus(String status);
}
