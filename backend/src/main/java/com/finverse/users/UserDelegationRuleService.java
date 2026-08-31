package com.finverse.users;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for UserDelegationRule
 */
public interface UserDelegationRuleService {

    List<UserDelegationRuleDto> getByTenant(UUID tenantId);

    List<UserDelegationRuleDto> getByUser(UUID userId);

    UserDelegationRuleDto create(UserDelegationRuleDto dto);

    UserDelegationRuleDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<UserDelegationRuleDto> listAll();
}
