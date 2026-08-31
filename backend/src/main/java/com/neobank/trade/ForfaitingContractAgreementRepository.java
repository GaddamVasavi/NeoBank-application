package com.neobank.trade;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ForfaitingContractAgreementRepository extends JpaRepository<ForfaitingContractAgreement, UUID> {
    List<ForfaitingContractAgreement> findByUserId(UUID userId);
    Optional<ForfaitingContractAgreement> findBySettlementRef(String ref);
    List<ForfaitingContractAgreement> findByLifecycleStatus(String status);
}
