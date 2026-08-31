package com.finverse.auth;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PasswordResetSessionToken
 */
public interface PasswordResetSessionTokenService {

    List<PasswordResetSessionTokenDto> getByTenant(UUID tenantId);

    List<PasswordResetSessionTokenDto> getByUser(UUID userId);

    PasswordResetSessionTokenDto create(PasswordResetSessionTokenDto dto);

    PasswordResetSessionTokenDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PasswordResetSessionTokenDto> listAll();
}
