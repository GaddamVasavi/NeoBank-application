package com.finverse.users;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for UserLoginHistoryAudit
 */
public interface UserLoginHistoryAuditService {

    List<UserLoginHistoryAuditDto> getByTenant(UUID tenantId);

    List<UserLoginHistoryAuditDto> getByUser(UUID userId);

    UserLoginHistoryAuditDto create(UserLoginHistoryAuditDto dto);

    UserLoginHistoryAuditDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<UserLoginHistoryAuditDto> listAll();
}
