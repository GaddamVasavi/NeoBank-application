package com.finverse.auth;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for RefreshTokenFamilyChain
 */
public interface RefreshTokenFamilyChainService {

    List<RefreshTokenFamilyChainDto> getByTenant(UUID tenantId);

    List<RefreshTokenFamilyChainDto> getByUser(UUID userId);

    RefreshTokenFamilyChainDto create(RefreshTokenFamilyChainDto dto);

    RefreshTokenFamilyChainDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<RefreshTokenFamilyChainDto> listAll();
}
