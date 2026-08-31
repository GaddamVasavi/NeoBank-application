package com.neobank.fintech;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface EmbeddedBankingPartnerTenantRepository extends JpaRepository<EmbeddedBankingPartnerTenant, UUID> {
    List<EmbeddedBankingPartnerTenant> findByUserId(UUID userId);
    Optional<EmbeddedBankingPartnerTenant> findByInstitutionalRef(String ref);
    List<EmbeddedBankingPartnerTenant> findByExecutionStatus(String status);
}
