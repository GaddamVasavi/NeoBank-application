package com.finverse.payments;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PaymentReceiptDossier
 */
public interface PaymentReceiptDossierService {

    List<PaymentReceiptDossierDto> getByTenant(UUID tenantId);

    List<PaymentReceiptDossierDto> getByUser(UUID userId);

    PaymentReceiptDossierDto create(PaymentReceiptDossierDto dto);

    PaymentReceiptDossierDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PaymentReceiptDossierDto> listAll();
}
