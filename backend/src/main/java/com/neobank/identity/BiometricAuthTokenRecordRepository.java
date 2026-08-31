package com.neobank.identity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BiometricAuthTokenRecordRepository extends JpaRepository<BiometricAuthTokenRecord, UUID> {
    List<BiometricAuthTokenRecord> findByUserId(UUID userId);
    Optional<BiometricAuthTokenRecord> findByRegistryKey(String key);
    List<BiometricAuthTokenRecord> findByDeliveryStatus(String status);
}
