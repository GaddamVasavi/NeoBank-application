package com.neobank.factoring;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InvoiceDisputeRetentionRepository extends JpaRepository<InvoiceDisputeRetention, UUID> {
    List<InvoiceDisputeRetention> findByUserId(UUID userId);
    Optional<InvoiceDisputeRetention> findByDossierReference(String ref);
    List<InvoiceDisputeRetention> findByOperationalStatus(String status);
}
