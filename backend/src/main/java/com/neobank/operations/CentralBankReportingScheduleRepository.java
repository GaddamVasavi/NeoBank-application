package com.neobank.operations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CentralBankReportingScheduleRepository extends JpaRepository<CentralBankReportingSchedule, UUID> {
    List<CentralBankReportingSchedule> findByUserId(UUID userId);
    Optional<CentralBankReportingSchedule> findByTrackingCode(String code);
    List<CentralBankReportingSchedule> findByStateFlag(String stateFlag);
}
