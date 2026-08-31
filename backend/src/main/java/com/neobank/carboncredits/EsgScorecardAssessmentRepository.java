package com.neobank.carboncredits;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EsgScorecardAssessmentRepository extends JpaRepository<EsgScorecardAssessment, UUID> {
    List<EsgScorecardAssessment> findByUserId(UUID userId);
    Optional<EsgScorecardAssessment> findByProtocolReference(String ref);
    List<EsgScorecardAssessment> findByOperationalState(String state);
}
