package com.neobank.investment;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface DividendPaymentCreditRepository extends JpaRepository<DividendPaymentCredit, UUID> {
    List<DividendPaymentCredit> findByUserId(UUID userId);
    Optional<DividendPaymentCredit> findByIdentifierCode(String code);
    List<DividendPaymentCredit> findByStatus(String status);
}
