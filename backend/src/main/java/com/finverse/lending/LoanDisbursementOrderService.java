package com.finverse.lending;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for LoanDisbursementOrder
 */
public interface LoanDisbursementOrderService {

    List<LoanDisbursementOrderDto> getByTenant(UUID tenantId);

    List<LoanDisbursementOrderDto> getByUser(UUID userId);

    LoanDisbursementOrderDto create(LoanDisbursementOrderDto dto);

    LoanDisbursementOrderDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<LoanDisbursementOrderDto> listAll();
}
