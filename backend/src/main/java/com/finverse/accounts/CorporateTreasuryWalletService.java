package com.finverse.accounts;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CorporateTreasuryWallet
 */
public interface CorporateTreasuryWalletService {

    List<CorporateTreasuryWalletDto> getByTenant(UUID tenantId);

    List<CorporateTreasuryWalletDto> getByUser(UUID userId);

    CorporateTreasuryWalletDto create(CorporateTreasuryWalletDto dto);

    CorporateTreasuryWalletDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CorporateTreasuryWalletDto> listAll();
}
