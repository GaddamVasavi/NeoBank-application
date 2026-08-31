package com.finverse.users;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for UserSecuritySessionLog
 */
public interface UserSecuritySessionLogService {

    List<UserSecuritySessionLogDto> getByTenant(UUID tenantId);

    List<UserSecuritySessionLogDto> getByUser(UUID userId);

    UserSecuritySessionLogDto create(UserSecuritySessionLogDto dto);

    UserSecuritySessionLogDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<UserSecuritySessionLogDto> listAll();
}
