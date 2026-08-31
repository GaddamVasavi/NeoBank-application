package com.neobank.auditstream;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TamperEvidentLogVerifierRepository extends JpaRepository<TamperEvidentLogVerifier, UUID> {
    List<TamperEvidentLogVerifier> findByUserId(UUID userId);
    Optional<TamperEvidentLogVerifier> findByCoreReference(String ref);
    List<TamperEvidentLogVerifier> findByProcessingStatus(String status);
}
