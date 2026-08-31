package com.finverse.accounts;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for EscrowCollateralAccount
 */
public interface EscrowCollateralAccountService {

    List<EscrowCollateralAccountDto> getByTenant(UUID tenantId);

    List<EscrowCollateralAccountDto> getByUser(UUID userId);

    EscrowCollateralAccountDto create(EscrowCollateralAccountDto dto);

    EscrowCollateralAccountDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<EscrowCollateralAccountDto> listAll();
}
