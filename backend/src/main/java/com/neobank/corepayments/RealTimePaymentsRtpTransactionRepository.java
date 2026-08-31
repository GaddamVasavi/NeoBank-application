package com.neobank.corepayments;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface RealTimePaymentsRtpTransactionRepository extends JpaRepository<RealTimePaymentsRtpTransaction, UUID> {
    List<RealTimePaymentsRtpTransaction> findByUserId(UUID userId);
    Optional<RealTimePaymentsRtpTransaction> findByClearingKey(String key);
    List<RealTimePaymentsRtpTransaction> findByAuditStatus(String status);
}
