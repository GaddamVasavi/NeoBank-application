package com.neobank.governance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RelatedPartyTransactionLogRepository extends JpaRepository<RelatedPartyTransactionLog, UUID> {
    List<RelatedPartyTransactionLog> findByUserId(UUID userId);
    Optional<RelatedPartyTransactionLog> findByInstitutionalRef(String ref);
    List<RelatedPartyTransactionLog> findByExecutionStatus(String status);
}
