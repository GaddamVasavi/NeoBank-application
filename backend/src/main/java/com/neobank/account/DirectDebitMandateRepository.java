package com.neobank.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DirectDebitMandateRepository extends JpaRepository<DirectDebitMandate, UUID> {
    List<DirectDebitMandate> findByAccountId(UUID accountId);
    Optional<DirectDebitMandate> findByReferenceCode(String ref);
    List<DirectDebitMandate> findByStatus(String status);
}
