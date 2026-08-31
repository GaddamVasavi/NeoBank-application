package com.neobank.interbankclearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ChapsSterlingClearingLogRepository extends JpaRepository<ChapsSterlingClearingLog, UUID> {
    List<ChapsSterlingClearingLog> findByUserId(UUID userId);
    Optional<ChapsSterlingClearingLog> findByProtocolReference(String ref);
    List<ChapsSterlingClearingLog> findByOperationalState(String state);
}
