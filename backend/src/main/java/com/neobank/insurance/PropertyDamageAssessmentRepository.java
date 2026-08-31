package com.neobank.insurance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PropertyDamageAssessmentRepository extends JpaRepository<PropertyDamageAssessment, UUID> {
    List<PropertyDamageAssessment> findByUserId(UUID userId);
    Optional<PropertyDamageAssessment> findByDossierReference(String ref);
    List<PropertyDamageAssessment> findByOperationalStatus(String status);
}
