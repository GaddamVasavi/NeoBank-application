package com.neobank.openbanking;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PaymentInitiationRequestLogRepository extends JpaRepository<PaymentInitiationRequestLog, UUID> {
    List<PaymentInitiationRequestLog> findByUserId(UUID userId);
    Optional<PaymentInitiationRequestLog> findByTrackingCode(String code);
    List<PaymentInitiationRequestLog> findByStateFlag(String stateFlag);
}
