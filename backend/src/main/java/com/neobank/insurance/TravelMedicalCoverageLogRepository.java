package com.neobank.insurance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TravelMedicalCoverageLogRepository extends JpaRepository<TravelMedicalCoverageLog, UUID> {
    List<TravelMedicalCoverageLog> findByUserId(UUID userId);
    Optional<TravelMedicalCoverageLog> findByDossierReference(String ref);
    List<TravelMedicalCoverageLog> findByOperationalStatus(String status);
}
