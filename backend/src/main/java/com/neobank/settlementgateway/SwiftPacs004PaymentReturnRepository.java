package com.neobank.settlementgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SwiftPacs004PaymentReturnRepository extends JpaRepository<SwiftPacs004PaymentReturn, UUID> {
    List<SwiftPacs004PaymentReturn> findByUserId(UUID userId);
    Optional<SwiftPacs004PaymentReturn> findByGatewayReference(String ref);
    List<SwiftPacs004PaymentReturn> findBySettlementState(String state);
}
