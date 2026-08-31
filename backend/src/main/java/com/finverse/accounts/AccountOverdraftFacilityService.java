package com.finverse.accounts;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for AccountOverdraftFacility
 */
public interface AccountOverdraftFacilityService {

    List<AccountOverdraftFacilityDto> getByTenant(UUID tenantId);

    List<AccountOverdraftFacilityDto> getByUser(UUID userId);

    AccountOverdraftFacilityDto create(AccountOverdraftFacilityDto dto);

    AccountOverdraftFacilityDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<AccountOverdraftFacilityDto> listAll();
}
