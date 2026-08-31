package com.neobank.auth;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.Optional; import java.util.UUID;
@Repository
public interface OtpRecordRepository extends JpaRepository<OtpRecord, UUID> {
    Optional<OtpRecord> findTopByContactTargetAndOtpTypeOrderByCreatedAtDesc(String contactTarget, OtpType otpType);
}
