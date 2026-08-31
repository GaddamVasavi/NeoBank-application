package com.finverse.tenant;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for TenantSecurityPolicy
 */
public interface TenantSecurityPolicyService {

    List<TenantSecurityPolicyDto> getByTenant(UUID tenantId);

    List<TenantSecurityPolicyDto> getByUser(UUID userId);

    TenantSecurityPolicyDto create(TenantSecurityPolicyDto dto);

    TenantSecurityPolicyDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<TenantSecurityPolicyDto> listAll();
}
