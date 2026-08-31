package com.neobank.digitalvault;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SessionRevocationBroadcastRepository extends JpaRepository<SessionRevocationBroadcast, UUID> {
    List<SessionRevocationBroadcast> findByUserId(UUID userId);
    Optional<SessionRevocationBroadcast> findByProtocolReference(String ref);
    List<SessionRevocationBroadcast> findByOperationalState(String state);
}
