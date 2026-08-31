package com.finverse.expenses;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for DepartmentExpenseBudget
 */
public interface DepartmentExpenseBudgetService {

    List<DepartmentExpenseBudgetDto> getByTenant(UUID tenantId);

    List<DepartmentExpenseBudgetDto> getByUser(UUID userId);

    DepartmentExpenseBudgetDto create(DepartmentExpenseBudgetDto dto);

    DepartmentExpenseBudgetDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<DepartmentExpenseBudgetDto> listAll();
}
