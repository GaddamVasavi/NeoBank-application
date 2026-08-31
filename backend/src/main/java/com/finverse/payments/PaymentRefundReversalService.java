package com.finverse.payments;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PaymentRefundReversal
 */
public interface PaymentRefundReversalService {

    List<PaymentRefundReversalDto> getByTenant(UUID tenantId);

    List<PaymentRefundReversalDto> getByUser(UUID userId);

    PaymentRefundReversalDto create(PaymentRefundReversalDto dto);

    PaymentRefundReversalDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PaymentRefundReversalDto> listAll();
}
