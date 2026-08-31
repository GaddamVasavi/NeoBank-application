package com.neobank.transfer;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SepaInstantPaymentRepository extends JpaRepository<SepaInstantPayment, UUID> {
    List<SepaInstantPayment> findBySourceAccountId(UUID accountId);
    Optional<SepaInstantPayment> findByTrackingNumber(String trackingNumber);
    List<SepaInstantPayment> findByStatus(String status);
}
