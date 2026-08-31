package com.finverse.compliance;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CurrencyTransactionReportCtr
 */
public interface CurrencyTransactionReportCtrService {

    List<CurrencyTransactionReportCtrDto> getByTenant(UUID tenantId);

    List<CurrencyTransactionReportCtrDto> getByUser(UUID userId);

    CurrencyTransactionReportCtrDto create(CurrencyTransactionReportCtrDto dto);

    CurrencyTransactionReportCtrDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CurrencyTransactionReportCtrDto> listAll();
}
