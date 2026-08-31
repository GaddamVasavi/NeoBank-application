package com.neobank.clearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DefaultFundContributionLedgerRepository extends JpaRepository<DefaultFundContributionLedger, UUID> {
    List<DefaultFundContributionLedger> findByUserId(UUID userId);
    Optional<DefaultFundContributionLedger> findByInstitutionalRef(String ref);
    List<DefaultFundContributionLedger> findByExecutionStatus(String status);
}
