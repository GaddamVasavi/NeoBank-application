package com.neobank.digitalvault;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EmergencyAccessDelegationRepository extends JpaRepository<EmergencyAccessDelegation, UUID> {
    List<EmergencyAccessDelegation> findByUserId(UUID userId);
    Optional<EmergencyAccessDelegation> findByProtocolReference(String ref);
    List<EmergencyAccessDelegation> findByOperationalState(String state);
}
