package com.finverse.payments;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PaymentCaptureSettlement
 */
public interface PaymentCaptureSettlementService {

    List<PaymentCaptureSettlementDto> getByTenant(UUID tenantId);

    List<PaymentCaptureSettlementDto> getByUser(UUID userId);

    PaymentCaptureSettlementDto create(PaymentCaptureSettlementDto dto);

    PaymentCaptureSettlementDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PaymentCaptureSettlementDto> listAll();
}
