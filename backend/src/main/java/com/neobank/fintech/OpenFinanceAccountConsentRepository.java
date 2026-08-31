package com.neobank.fintech;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface OpenFinanceAccountConsentRepository extends JpaRepository<OpenFinanceAccountConsent, UUID> {
    List<OpenFinanceAccountConsent> findByUserId(UUID userId);
    Optional<OpenFinanceAccountConsent> findByInstitutionalRef(String ref);
    List<OpenFinanceAccountConsent> findByExecutionStatus(String status);
}
