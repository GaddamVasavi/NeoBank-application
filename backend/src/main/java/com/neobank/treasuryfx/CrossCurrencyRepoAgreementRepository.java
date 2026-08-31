package com.neobank.treasuryfx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CrossCurrencyRepoAgreementRepository extends JpaRepository<CrossCurrencyRepoAgreement, UUID> {
    List<CrossCurrencyRepoAgreement> findByUserId(UUID userId);
    Optional<CrossCurrencyRepoAgreement> findByInstitutionalRef(String ref);
    List<CrossCurrencyRepoAgreement> findByExecutionStatus(String status);
}
