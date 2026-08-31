package com.finverse.accounts;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for AccountSpendLimitRule
 */
public interface AccountSpendLimitRuleService {

    List<AccountSpendLimitRuleDto> getByTenant(UUID tenantId);

    List<AccountSpendLimitRuleDto> getByUser(UUID userId);

    AccountSpendLimitRuleDto create(AccountSpendLimitRuleDto dto);

    AccountSpendLimitRuleDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<AccountSpendLimitRuleDto> listAll();
}
