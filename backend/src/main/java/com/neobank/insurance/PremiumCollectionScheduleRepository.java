package com.neobank.insurance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PremiumCollectionScheduleRepository extends JpaRepository<PremiumCollectionSchedule, UUID> {
    List<PremiumCollectionSchedule> findByUserId(UUID userId);
    Optional<PremiumCollectionSchedule> findByDossierReference(String ref);
    List<PremiumCollectionSchedule> findByOperationalStatus(String status);
}
