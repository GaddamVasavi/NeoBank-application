package com.neobank.paymentsgateway;
import java.util.List; import java.util.UUID;
public interface PaymentGatewayMerchantConfigService {
    List<PaymentGatewayMerchantConfigDto> getByUser(UUID userId);
    PaymentGatewayMerchantConfigDto create(PaymentGatewayMerchantConfigDto dto);
    PaymentGatewayMerchantConfigDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<PaymentGatewayMerchantConfigDto> listAll();
}
