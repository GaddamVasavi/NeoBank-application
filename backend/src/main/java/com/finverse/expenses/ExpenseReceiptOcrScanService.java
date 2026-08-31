package com.finverse.expenses;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ExpenseReceiptOcrScan
 */
public interface ExpenseReceiptOcrScanService {

    List<ExpenseReceiptOcrScanDto> getByTenant(UUID tenantId);

    List<ExpenseReceiptOcrScanDto> getByUser(UUID userId);

    ExpenseReceiptOcrScanDto create(ExpenseReceiptOcrScanDto dto);

    ExpenseReceiptOcrScanDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ExpenseReceiptOcrScanDto> listAll();
}
