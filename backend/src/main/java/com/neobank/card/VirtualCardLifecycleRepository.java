package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface VirtualCardLifecycleRepository extends JpaRepository<VirtualCardLifecycle, UUID> {
    List<VirtualCardLifecycle> findByUserId(UUID userId);
    Optional<VirtualCardLifecycle> findByRecordKey(String recordKey);
    List<VirtualCardLifecycle> findByStatus(String status);
}
