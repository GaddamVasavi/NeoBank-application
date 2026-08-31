package com.neobank.digitalvault;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DigitalIdentityClaimRecordRepository extends JpaRepository<DigitalIdentityClaimRecord, UUID> {
    List<DigitalIdentityClaimRecord> findByUserId(UUID userId);
    Optional<DigitalIdentityClaimRecord> findByProtocolReference(String ref);
    List<DigitalIdentityClaimRecord> findByOperationalState(String state);
}
