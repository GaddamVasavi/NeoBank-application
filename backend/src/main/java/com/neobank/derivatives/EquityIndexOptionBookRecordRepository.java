package com.neobank.derivatives;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EquityIndexOptionBookRecordRepository extends JpaRepository<EquityIndexOptionBookRecord, UUID> {
    List<EquityIndexOptionBookRecord> findByUserId(UUID userId);
    Optional<EquityIndexOptionBookRecord> findByClearingKey(String key);
    List<EquityIndexOptionBookRecord> findByAuditStatus(String status);
}
