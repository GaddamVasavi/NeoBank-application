package com.finverse.users;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for UserContactDirectory
 */
public interface UserContactDirectoryService {

    List<UserContactDirectoryDto> getByTenant(UUID tenantId);

    List<UserContactDirectoryDto> getByUser(UUID userId);

    UserContactDirectoryDto create(UserContactDirectoryDto dto);

    UserContactDirectoryDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<UserContactDirectoryDto> listAll();
}
