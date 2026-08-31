package com.neobank.fintech;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DecentralizedIdentityClaimRepository extends JpaRepository<DecentralizedIdentityClaim, UUID> {
    List<DecentralizedIdentityClaim> findByUserId(UUID userId);
    Optional<DecentralizedIdentityClaim> findByInstitutionalRef(String ref);
    List<DecentralizedIdentityClaim> findByExecutionStatus(String status);
}
