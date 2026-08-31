package com.neobank.paymentsgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PaymentGatewayMerchantConfigRepository extends JpaRepository<PaymentGatewayMerchantConfig, UUID> {
    List<PaymentGatewayMerchantConfig> findByUserId(UUID userId);
    Optional<PaymentGatewayMerchantConfig> findBySystemIdentifier(String id);
    List<PaymentGatewayMerchantConfig> findByValidationState(String state);
}
