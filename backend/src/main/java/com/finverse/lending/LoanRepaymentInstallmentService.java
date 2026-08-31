package com.finverse.lending;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for LoanRepaymentInstallment
 */
public interface LoanRepaymentInstallmentService {

    List<LoanRepaymentInstallmentDto> getByTenant(UUID tenantId);

    List<LoanRepaymentInstallmentDto> getByUser(UUID userId);

    LoanRepaymentInstallmentDto create(LoanRepaymentInstallmentDto dto);

    LoanRepaymentInstallmentDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<LoanRepaymentInstallmentDto> listAll();
}
