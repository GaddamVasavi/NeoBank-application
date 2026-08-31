package com.finverse.expenses;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for EmployeeExpenseItem
 */
public interface EmployeeExpenseItemService {

    List<EmployeeExpenseItemDto> getByTenant(UUID tenantId);

    List<EmployeeExpenseItemDto> getByUser(UUID userId);

    EmployeeExpenseItemDto create(EmployeeExpenseItemDto dto);

    EmployeeExpenseItemDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<EmployeeExpenseItemDto> listAll();
}
