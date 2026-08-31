package com.neobank.interbankclearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BilateralNettingAgreementRepository extends JpaRepository<BilateralNettingAgreement, UUID> {
    List<BilateralNettingAgreement> findByUserId(UUID userId);
    Optional<BilateralNettingAgreement> findByProtocolReference(String ref);
    List<BilateralNettingAgreement> findByOperationalState(String state);
}
