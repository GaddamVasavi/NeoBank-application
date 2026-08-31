package com.neobank.privateequity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface KeyPersonClauseTriggerRepository extends JpaRepository<KeyPersonClauseTrigger, UUID> {
    List<KeyPersonClauseTrigger> findByUserId(UUID userId);
    Optional<KeyPersonClauseTrigger> findByProtocolReference(String ref);
    List<KeyPersonClauseTrigger> findByOperationalState(String state);
}
