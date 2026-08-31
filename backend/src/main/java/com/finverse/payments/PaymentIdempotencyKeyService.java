package com.finverse.payments;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PaymentIdempotencyKey
 */
public interface PaymentIdempotencyKeyService {

    List<PaymentIdempotencyKeyDto> getByTenant(UUID tenantId);

    List<PaymentIdempotencyKeyDto> getByUser(UUID userId);

    PaymentIdempotencyKeyDto create(PaymentIdempotencyKeyDto dto);

    PaymentIdempotencyKeyDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PaymentIdempotencyKeyDto> listAll();
}
