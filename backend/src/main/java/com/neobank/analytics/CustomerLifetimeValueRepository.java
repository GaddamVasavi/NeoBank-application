package com.neobank.analytics;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CustomerLifetimeValueRepository extends JpaRepository<CustomerLifetimeValue, UUID> {
    List<CustomerLifetimeValue> findByUserId(UUID userId);
    Optional<CustomerLifetimeValue> findByRecordKey(String recordKey);
    List<CustomerLifetimeValue> findByStatus(String status);
}
