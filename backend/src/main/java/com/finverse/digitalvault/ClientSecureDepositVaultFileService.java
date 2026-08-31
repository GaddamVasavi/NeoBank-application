package com.finverse.digitalvault;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for ClientSecureDepositVaultFile
 */
public interface ClientSecureDepositVaultFileService {

    List<ClientSecureDepositVaultFileDto> getByTenant(UUID tenantId);

    List<ClientSecureDepositVaultFileDto> getByUser(UUID userId);

    ClientSecureDepositVaultFileDto create(ClientSecureDepositVaultFileDto dto);

    ClientSecureDepositVaultFileDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<ClientSecureDepositVaultFileDto> listAll();
}
