package com.finverse.payments;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PaymentRoutingRuleConfig
 */
public interface PaymentRoutingRuleConfigService {

    List<PaymentRoutingRuleConfigDto> getByTenant(UUID tenantId);

    List<PaymentRoutingRuleConfigDto> getByUser(UUID userId);

    PaymentRoutingRuleConfigDto create(PaymentRoutingRuleConfigDto dto);

    PaymentRoutingRuleConfigDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PaymentRoutingRuleConfigDto> listAll();
}
