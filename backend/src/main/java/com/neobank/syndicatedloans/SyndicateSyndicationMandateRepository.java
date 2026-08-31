package com.neobank.syndicatedloans;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SyndicateSyndicationMandateRepository extends JpaRepository<SyndicateSyndicationMandate, UUID> {
    List<SyndicateSyndicationMandate> findByUserId(UUID userId);
    Optional<SyndicateSyndicationMandate> findByProtocolReference(String ref);
    List<SyndicateSyndicationMandate> findByOperationalState(String state);
}
