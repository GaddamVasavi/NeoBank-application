package com.neobank.digitalvault;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EncryptedDocumentVaultFileRepository extends JpaRepository<EncryptedDocumentVaultFile, UUID> {
    List<EncryptedDocumentVaultFile> findByUserId(UUID userId);
    Optional<EncryptedDocumentVaultFile> findByProtocolReference(String ref);
    List<EncryptedDocumentVaultFile> findByOperationalState(String state);
}
