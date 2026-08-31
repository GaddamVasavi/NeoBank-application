package com.finverse.users;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for UserDepartmentHierarchy
 */
public interface UserDepartmentHierarchyService {

    List<UserDepartmentHierarchyDto> getByTenant(UUID tenantId);

    List<UserDepartmentHierarchyDto> getByUser(UUID userId);

    UserDepartmentHierarchyDto create(UserDepartmentHierarchyDto dto);

    UserDepartmentHierarchyDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<UserDepartmentHierarchyDto> listAll();
}
