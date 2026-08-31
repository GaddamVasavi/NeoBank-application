package com.neobank.marketing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ReferralBonusLedgerEntryRepository extends JpaRepository<ReferralBonusLedgerEntry, UUID> {
    List<ReferralBonusLedgerEntry> findByUserId(UUID userId);
    Optional<ReferralBonusLedgerEntry> findByTrackingCode(String code);
    List<ReferralBonusLedgerEntry> findByStateFlag(String stateFlag);
}
