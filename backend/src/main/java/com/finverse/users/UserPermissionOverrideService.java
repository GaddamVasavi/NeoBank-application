package com.finverse.users;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for UserPermissionOverride
 */
public interface UserPermissionOverrideService {

    List<UserPermissionOverrideDto> getByTenant(UUID tenantId);

    List<UserPermissionOverrideDto> getByUser(UUID userId);

    UserPermissionOverrideDto create(UserPermissionOverrideDto dto);

    UserPermissionOverrideDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<UserPermissionOverrideDto> listAll();
}
