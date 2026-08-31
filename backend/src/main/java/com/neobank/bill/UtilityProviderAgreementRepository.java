package com.neobank.bill;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface UtilityProviderAgreementRepository extends JpaRepository<UtilityProviderAgreement, UUID> {
    List<UtilityProviderAgreement> findByUserId(UUID userId);
    Optional<UtilityProviderAgreement> findByRecordKey(String recordKey);
    List<UtilityProviderAgreement> findByStatus(String status);
}
