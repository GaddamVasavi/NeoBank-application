package com.neobank.digitalvault;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ZeroKnowledgeProofAttestationRepository extends JpaRepository<ZeroKnowledgeProofAttestation, UUID> {
    List<ZeroKnowledgeProofAttestation> findByUserId(UUID userId);
    Optional<ZeroKnowledgeProofAttestation> findByProtocolReference(String ref);
    List<ZeroKnowledgeProofAttestation> findByOperationalState(String state);
}
