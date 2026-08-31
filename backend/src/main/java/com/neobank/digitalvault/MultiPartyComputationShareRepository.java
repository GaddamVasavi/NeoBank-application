package com.neobank.digitalvault;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MultiPartyComputationShareRepository extends JpaRepository<MultiPartyComputationShare, UUID> {
    List<MultiPartyComputationShare> findByUserId(UUID userId);
    Optional<MultiPartyComputationShare> findByProtocolReference(String ref);
    List<MultiPartyComputationShare> findByOperationalState(String state);
}
