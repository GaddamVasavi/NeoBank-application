package com.finverse.auth;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for AuthMfaEnrollmentMaster
 */
public interface AuthMfaEnrollmentMasterService {

    List<AuthMfaEnrollmentMasterDto> getByTenant(UUID tenantId);

    List<AuthMfaEnrollmentMasterDto> getByUser(UUID userId);

    AuthMfaEnrollmentMasterDto create(AuthMfaEnrollmentMasterDto dto);

    AuthMfaEnrollmentMasterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<AuthMfaEnrollmentMasterDto> listAll();
}
