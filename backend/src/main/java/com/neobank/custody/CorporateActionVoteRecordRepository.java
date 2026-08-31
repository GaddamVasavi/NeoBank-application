package com.neobank.custody;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CorporateActionVoteRecordRepository extends JpaRepository<CorporateActionVoteRecord, UUID> {
    List<CorporateActionVoteRecord> findByUserId(UUID userId);
    Optional<CorporateActionVoteRecord> findBySettlementRef(String ref);
    List<CorporateActionVoteRecord> findByLifecycleStatus(String status);
}
