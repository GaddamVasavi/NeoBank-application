package com.neobank.leasing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LeaseAmortizationScheduleRepository extends JpaRepository<LeaseAmortizationSchedule, UUID> {
    List<LeaseAmortizationSchedule> findByUserId(UUID userId);
    Optional<LeaseAmortizationSchedule> findByDossierReference(String ref);
    List<LeaseAmortizationSchedule> findByOperationalStatus(String status);
}
