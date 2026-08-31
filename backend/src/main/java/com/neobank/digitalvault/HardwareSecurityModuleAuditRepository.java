package com.neobank.digitalvault;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface HardwareSecurityModuleAuditRepository extends JpaRepository<HardwareSecurityModuleAudit, UUID> {
    List<HardwareSecurityModuleAudit> findByUserId(UUID userId);
    Optional<HardwareSecurityModuleAudit> findByProtocolReference(String ref);
    List<HardwareSecurityModuleAudit> findByOperationalState(String state);
}
