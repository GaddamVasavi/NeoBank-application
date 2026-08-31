package com.neobank.risk;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CounterpartyExposureRecordRepository extends JpaRepository<CounterpartyExposureRecord, UUID> {
    List<CounterpartyExposureRecord> findByUserId(UUID userId);
    Optional<CounterpartyExposureRecord> findByTrackingCode(String code);
    List<CounterpartyExposureRecord> findByStateFlag(String stateFlag);
}
