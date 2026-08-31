package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SuspiciousActivityReportRepository extends JpaRepository<SuspiciousActivityReport, UUID> {
    List<SuspiciousActivityReport> findByUserId(UUID userId);
    Optional<SuspiciousActivityReport> findByCodeReference(String ref);
    List<SuspiciousActivityReport> findByStatus(String status);
}
