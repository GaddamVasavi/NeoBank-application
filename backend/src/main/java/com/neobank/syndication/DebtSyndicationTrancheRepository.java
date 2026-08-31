package com.neobank.syndication;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DebtSyndicationTrancheRepository extends JpaRepository<DebtSyndicationTranche, UUID> {
    List<DebtSyndicationTranche> findByUserId(UUID userId);
    Optional<DebtSyndicationTranche> findByDossierReference(String ref);
    List<DebtSyndicationTranche> findByOperationalStatus(String status);
}
