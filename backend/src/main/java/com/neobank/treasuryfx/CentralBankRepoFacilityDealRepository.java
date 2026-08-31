package com.neobank.treasuryfx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CentralBankRepoFacilityDealRepository extends JpaRepository<CentralBankRepoFacilityDeal, UUID> {
    List<CentralBankRepoFacilityDeal> findByUserId(UUID userId);
    Optional<CentralBankRepoFacilityDeal> findByInstitutionalRef(String ref);
    List<CentralBankRepoFacilityDeal> findByExecutionStatus(String status);
}
