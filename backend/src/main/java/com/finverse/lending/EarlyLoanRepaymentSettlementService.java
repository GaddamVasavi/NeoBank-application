package com.finverse.lending;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for EarlyLoanRepaymentSettlement
 */
public interface EarlyLoanRepaymentSettlementService {

    List<EarlyLoanRepaymentSettlementDto> getByTenant(UUID tenantId);

    List<EarlyLoanRepaymentSettlementDto> getByUser(UUID userId);

    EarlyLoanRepaymentSettlementDto create(EarlyLoanRepaymentSettlementDto dto);

    EarlyLoanRepaymentSettlementDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<EarlyLoanRepaymentSettlementDto> listAll();
}
