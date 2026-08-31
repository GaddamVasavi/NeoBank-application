package com.neobank.operations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CashInTransitRecordRepository extends JpaRepository<CashInTransitRecord, UUID> {
    List<CashInTransitRecord> findByUserId(UUID userId);
    Optional<CashInTransitRecord> findByTrackingCode(String code);
    List<CashInTransitRecord> findByStateFlag(String stateFlag);
}
