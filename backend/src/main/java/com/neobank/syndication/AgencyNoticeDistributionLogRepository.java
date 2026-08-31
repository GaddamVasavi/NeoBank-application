package com.neobank.syndication;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AgencyNoticeDistributionLogRepository extends JpaRepository<AgencyNoticeDistributionLog, UUID> {
    List<AgencyNoticeDistributionLog> findByUserId(UUID userId);
    Optional<AgencyNoticeDistributionLog> findByDossierReference(String ref);
    List<AgencyNoticeDistributionLog> findByOperationalStatus(String status);
}
