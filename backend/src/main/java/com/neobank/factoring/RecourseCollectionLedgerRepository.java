package com.neobank.factoring;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RecourseCollectionLedgerRepository extends JpaRepository<RecourseCollectionLedger, UUID> {
    List<RecourseCollectionLedger> findByUserId(UUID userId);
    Optional<RecourseCollectionLedger> findByDossierReference(String ref);
    List<RecourseCollectionLedger> findByOperationalStatus(String status);
}
