package com.neobank.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface VaultSecretRotationLogRepository extends JpaRepository<VaultSecretRotationLog, UUID> {
    List<VaultSecretRotationLog> findByUserId(UUID userId);
    Optional<VaultSecretRotationLog> findByDossierReference(String ref);
    List<VaultSecretRotationLog> findByOperationalStatus(String status);
}
