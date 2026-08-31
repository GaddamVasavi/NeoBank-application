package com.finverse.payments;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PaymentOrderExecution
 */
public interface PaymentOrderExecutionService {

    List<PaymentOrderExecutionDto> getByTenant(UUID tenantId);

    List<PaymentOrderExecutionDto> getByUser(UUID userId);

    PaymentOrderExecutionDto create(PaymentOrderExecutionDto dto);

    PaymentOrderExecutionDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PaymentOrderExecutionDto> listAll();
}
