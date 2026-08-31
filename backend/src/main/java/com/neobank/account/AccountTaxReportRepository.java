package com.neobank.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AccountTaxReportRepository extends JpaRepository<AccountTaxReport, UUID> {
    List<AccountTaxReport> findByAccountId(UUID accountId);
    Optional<AccountTaxReport> findByReferenceCode(String ref);
    List<AccountTaxReport> findByStatus(String status);
}
