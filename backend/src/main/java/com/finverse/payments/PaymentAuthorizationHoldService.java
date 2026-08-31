package com.finverse.payments;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PaymentAuthorizationHold
 */
public interface PaymentAuthorizationHoldService {

    List<PaymentAuthorizationHoldDto> getByTenant(UUID tenantId);

    List<PaymentAuthorizationHoldDto> getByUser(UUID userId);

    PaymentAuthorizationHoldDto create(PaymentAuthorizationHoldDto dto);

    PaymentAuthorizationHoldDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PaymentAuthorizationHoldDto> listAll();
}
