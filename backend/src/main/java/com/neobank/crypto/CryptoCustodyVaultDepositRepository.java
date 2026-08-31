package com.neobank.crypto;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CryptoCustodyVaultDepositRepository extends JpaRepository<CryptoCustodyVaultDeposit, UUID> {
    List<CryptoCustodyVaultDeposit> findByUserId(UUID userId);
    Optional<CryptoCustodyVaultDeposit> findByAuthorityRef(String ref);
    List<CryptoCustodyVaultDeposit> findBySubmissionStatus(String status);
}
