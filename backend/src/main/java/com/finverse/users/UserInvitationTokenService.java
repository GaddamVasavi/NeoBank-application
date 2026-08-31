package com.finverse.users;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for UserInvitationToken
 */
public interface UserInvitationTokenService {

    List<UserInvitationTokenDto> getByTenant(UUID tenantId);

    List<UserInvitationTokenDto> getByUser(UUID userId);

    UserInvitationTokenDto create(UserInvitationTokenDto dto);

    UserInvitationTokenDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<UserInvitationTokenDto> listAll();
}
