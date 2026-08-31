package com.neobank.kyc;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BiometricVerificationLogRepository extends JpaRepository<BiometricVerificationLog, UUID> {
    List<BiometricVerificationLog> findByUserId(UUID userId);
    Optional<BiometricVerificationLog> findByCodeReference(String ref);
    List<BiometricVerificationLog> findByStatus(String status);
}
