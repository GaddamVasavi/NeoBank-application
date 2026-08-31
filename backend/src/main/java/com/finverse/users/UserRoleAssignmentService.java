package com.finverse.users;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for UserRoleAssignment
 */
public interface UserRoleAssignmentService {

    List<UserRoleAssignmentDto> getByTenant(UUID tenantId);

    List<UserRoleAssignmentDto> getByUser(UUID userId);

    UserRoleAssignmentDto create(UserRoleAssignmentDto dto);

    UserRoleAssignmentDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<UserRoleAssignmentDto> listAll();
}
