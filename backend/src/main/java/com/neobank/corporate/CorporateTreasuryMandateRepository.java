package com.neobank.corporate;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CorporateTreasuryMandateRepository extends JpaRepository<CorporateTreasuryMandate, UUID> {
    List<CorporateTreasuryMandate> findByUserId(UUID userId);
    Optional<CorporateTreasuryMandate> findByTrackingCode(String code);
    List<CorporateTreasuryMandate> findByStateFlag(String stateFlag);
}
