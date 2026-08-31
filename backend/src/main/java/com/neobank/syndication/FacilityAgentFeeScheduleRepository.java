package com.neobank.syndication;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FacilityAgentFeeScheduleRepository extends JpaRepository<FacilityAgentFeeSchedule, UUID> {
    List<FacilityAgentFeeSchedule> findByUserId(UUID userId);
    Optional<FacilityAgentFeeSchedule> findByDossierReference(String ref);
    List<FacilityAgentFeeSchedule> findByOperationalStatus(String status);
}
