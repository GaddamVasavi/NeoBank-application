package com.neobank.syndicatedloans;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LenderVotingRecordRepository extends JpaRepository<LenderVotingRecord, UUID> {
    List<LenderVotingRecord> findByUserId(UUID userId);
    Optional<LenderVotingRecord> findByProtocolReference(String ref);
    List<LenderVotingRecord> findByOperationalState(String state);
}
