package com.neobank.leasing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ResidualValueValuationRepository extends JpaRepository<ResidualValueValuation, UUID> {
    List<ResidualValueValuation> findByUserId(UUID userId);
    Optional<ResidualValueValuation> findByDossierReference(String ref);
    List<ResidualValueValuation> findByOperationalStatus(String status);
}
