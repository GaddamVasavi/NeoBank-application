package com.neobank.collateral;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SecuritiesPledgeAgreementRepository extends JpaRepository<SecuritiesPledgeAgreement, UUID> {
    List<SecuritiesPledgeAgreement> findByUserId(UUID userId);
    Optional<SecuritiesPledgeAgreement> findByCoreReference(String ref);
    List<SecuritiesPledgeAgreement> findByProcessingStatus(String status);
}
