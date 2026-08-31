package com.neobank.fintech;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface StablecoinReserveAuditFileRepository extends JpaRepository<StablecoinReserveAuditFile, UUID> {
    List<StablecoinReserveAuditFile> findByUserId(UUID userId);
    Optional<StablecoinReserveAuditFile> findByInstitutionalRef(String ref);
    List<StablecoinReserveAuditFile> findByExecutionStatus(String status);
}
