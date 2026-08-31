package com.neobank.syndication;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SecondaryLoanTradeRecordRepository extends JpaRepository<SecondaryLoanTradeRecord, UUID> {
    List<SecondaryLoanTradeRecord> findByUserId(UUID userId);
    Optional<SecondaryLoanTradeRecord> findByDossierReference(String ref);
    List<SecondaryLoanTradeRecord> findByOperationalStatus(String status);
}
