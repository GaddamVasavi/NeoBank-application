package com.finverse.digitalvault;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for MpcKeyShamirSecretShare
 */
public interface MpcKeyShamirSecretShareService {

    List<MpcKeyShamirSecretShareDto> getByTenant(UUID tenantId);

    List<MpcKeyShamirSecretShareDto> getByUser(UUID userId);

    MpcKeyShamirSecretShareDto create(MpcKeyShamirSecretShareDto dto);

    MpcKeyShamirSecretShareDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<MpcKeyShamirSecretShareDto> listAll();
}
