package com.neobank.leasing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EarlyLeaseTerminationQuoteRepository extends JpaRepository<EarlyLeaseTerminationQuote, UUID> {
    List<EarlyLeaseTerminationQuote> findByUserId(UUID userId);
    Optional<EarlyLeaseTerminationQuote> findByDossierReference(String ref);
    List<EarlyLeaseTerminationQuote> findByOperationalStatus(String status);
}
