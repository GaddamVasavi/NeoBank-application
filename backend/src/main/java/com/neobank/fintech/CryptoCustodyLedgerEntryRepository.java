package com.neobank.fintech;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CryptoCustodyLedgerEntryRepository extends JpaRepository<CryptoCustodyLedgerEntry, UUID> {
    List<CryptoCustodyLedgerEntry> findByUserId(UUID userId);
    Optional<CryptoCustodyLedgerEntry> findByInstitutionalRef(String ref);
    List<CryptoCustodyLedgerEntry> findByExecutionStatus(String status);
}
