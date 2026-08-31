package com.finverse.accounts;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SubAccountHierarchyNode
 */
public interface SubAccountHierarchyNodeService {

    List<SubAccountHierarchyNodeDto> getByTenant(UUID tenantId);

    List<SubAccountHierarchyNodeDto> getByUser(UUID userId);

    SubAccountHierarchyNodeDto create(SubAccountHierarchyNodeDto dto);

    SubAccountHierarchyNodeDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SubAccountHierarchyNodeDto> listAll();
}
