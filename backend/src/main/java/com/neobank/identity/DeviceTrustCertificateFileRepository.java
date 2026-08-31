package com.neobank.identity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DeviceTrustCertificateFileRepository extends JpaRepository<DeviceTrustCertificateFile, UUID> {
    List<DeviceTrustCertificateFile> findByUserId(UUID userId);
    Optional<DeviceTrustCertificateFile> findByRegistryKey(String key);
    List<DeviceTrustCertificateFile> findByDeliveryStatus(String status);
}
