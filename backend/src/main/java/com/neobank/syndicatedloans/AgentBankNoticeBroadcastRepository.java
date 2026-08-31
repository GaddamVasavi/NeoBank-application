package com.neobank.syndicatedloans;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AgentBankNoticeBroadcastRepository extends JpaRepository<AgentBankNoticeBroadcast, UUID> {
    List<AgentBankNoticeBroadcast> findByUserId(UUID userId);
    Optional<AgentBankNoticeBroadcast> findByProtocolReference(String ref);
    List<AgentBankNoticeBroadcast> findByOperationalState(String state);
}
