package com.neobank.kyc;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CorporateBeneficialOwnerRepository extends JpaRepository<CorporateBeneficialOwner, UUID> {
    List<CorporateBeneficialOwner> findByUserId(UUID userId);
    Optional<CorporateBeneficialOwner> findByRecordKey(String recordKey);
    List<CorporateBeneficialOwner> findByStatus(String status);
}
