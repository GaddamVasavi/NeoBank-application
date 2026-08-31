package com.neobank.custody;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ProxyVotingMandateRecordRepository extends JpaRepository<ProxyVotingMandateRecord, UUID> {
    List<ProxyVotingMandateRecord> findByUserId(UUID userId);
    Optional<ProxyVotingMandateRecord> findBySettlementRef(String ref);
    List<ProxyVotingMandateRecord> findByLifecycleStatus(String status);
}
