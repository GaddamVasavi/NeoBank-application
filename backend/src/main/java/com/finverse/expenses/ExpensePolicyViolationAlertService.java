package com.finverse.expenses;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ExpensePolicyViolationAlert
 */
public interface ExpensePolicyViolationAlertService {

    List<ExpensePolicyViolationAlertDto> getByTenant(UUID tenantId);

    List<ExpensePolicyViolationAlertDto> getByUser(UUID userId);

    ExpensePolicyViolationAlertDto create(ExpensePolicyViolationAlertDto dto);

    ExpensePolicyViolationAlertDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ExpensePolicyViolationAlertDto> listAll();
}
