package com.neobank.kyc;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface KycRenewalScheduleRepository extends JpaRepository<KycRenewalSchedule, UUID> {
    List<KycRenewalSchedule> findByUserId(UUID userId);
    Optional<KycRenewalSchedule> findByRecordKey(String recordKey);
    List<KycRenewalSchedule> findByStatus(String status);
}
