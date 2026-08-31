package com.neobank.custody;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SecuritiesLendingAgreementRepository extends JpaRepository<SecuritiesLendingAgreement, UUID> {
    List<SecuritiesLendingAgreement> findByUserId(UUID userId);
    Optional<SecuritiesLendingAgreement> findBySettlementRef(String ref);
    List<SecuritiesLendingAgreement> findByLifecycleStatus(String status);
}
