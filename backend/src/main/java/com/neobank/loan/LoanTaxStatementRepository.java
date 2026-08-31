package com.neobank.loan;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LoanTaxStatementRepository extends JpaRepository<LoanTaxStatement, UUID> {
    List<LoanTaxStatement> findByUserId(UUID userId);
    Optional<LoanTaxStatement> findByRecordKey(String recordKey);
    List<LoanTaxStatement> findByStatus(String status);
}
