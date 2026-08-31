package com.finverse.subscriptions;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for BillingHistoryReceipt
 */
public interface BillingHistoryReceiptService {

    List<BillingHistoryReceiptDto> getByTenant(UUID tenantId);

    List<BillingHistoryReceiptDto> getByUser(UUID userId);

    BillingHistoryReceiptDto create(BillingHistoryReceiptDto dto);

    BillingHistoryReceiptDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<BillingHistoryReceiptDto> listAll();
}
