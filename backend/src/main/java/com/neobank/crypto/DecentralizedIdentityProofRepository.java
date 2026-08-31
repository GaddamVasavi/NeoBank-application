package com.neobank.crypto;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DecentralizedIdentityProofRepository extends JpaRepository<DecentralizedIdentityProof, UUID> {
    List<DecentralizedIdentityProof> findByUserId(UUID userId);
    Optional<DecentralizedIdentityProof> findByAuthorityRef(String ref);
    List<DecentralizedIdentityProof> findBySubmissionStatus(String status);
}
