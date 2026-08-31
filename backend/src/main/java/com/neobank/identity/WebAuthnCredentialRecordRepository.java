package com.neobank.identity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface WebAuthnCredentialRecordRepository extends JpaRepository<WebAuthnCredentialRecord, UUID> {
    List<WebAuthnCredentialRecord> findByUserId(UUID userId);
    Optional<WebAuthnCredentialRecord> findByRegistryKey(String key);
    List<WebAuthnCredentialRecord> findByDeliveryStatus(String status);
}
