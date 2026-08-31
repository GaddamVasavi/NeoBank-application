package com.neobank.admin;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BatchSettlementJobRepository extends JpaRepository<BatchSettlementJob, UUID> {
    List<BatchSettlementJob> findByUserId(UUID userId);
    Optional<BatchSettlementJob> findByRecordKey(String recordKey);
    List<BatchSettlementJob> findByStatus(String status);
}
