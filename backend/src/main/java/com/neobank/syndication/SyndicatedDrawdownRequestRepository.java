package com.neobank.syndication;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SyndicatedDrawdownRequestRepository extends JpaRepository<SyndicatedDrawdownRequest, UUID> {
    List<SyndicatedDrawdownRequest> findByUserId(UUID userId);
    Optional<SyndicatedDrawdownRequest> findByDossierReference(String ref);
    List<SyndicatedDrawdownRequest> findByOperationalStatus(String status);
}
