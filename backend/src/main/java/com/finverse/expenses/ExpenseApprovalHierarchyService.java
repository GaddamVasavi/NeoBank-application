package com.finverse.expenses;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ExpenseApprovalHierarchy
 */
public interface ExpenseApprovalHierarchyService {

    List<ExpenseApprovalHierarchyDto> getByTenant(UUID tenantId);

    List<ExpenseApprovalHierarchyDto> getByUser(UUID userId);

    ExpenseApprovalHierarchyDto create(ExpenseApprovalHierarchyDto dto);

    ExpenseApprovalHierarchyDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ExpenseApprovalHierarchyDto> listAll();
}
