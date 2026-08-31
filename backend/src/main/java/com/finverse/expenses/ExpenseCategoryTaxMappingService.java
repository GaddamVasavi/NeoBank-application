package com.finverse.expenses;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ExpenseCategoryTaxMapping
 */
public interface ExpenseCategoryTaxMappingService {

    List<ExpenseCategoryTaxMappingDto> getByTenant(UUID tenantId);

    List<ExpenseCategoryTaxMappingDto> getByUser(UUID userId);

    ExpenseCategoryTaxMappingDto create(ExpenseCategoryTaxMappingDto dto);

    ExpenseCategoryTaxMappingDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ExpenseCategoryTaxMappingDto> listAll();
}
