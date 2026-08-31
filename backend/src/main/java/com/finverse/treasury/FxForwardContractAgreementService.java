package com.finverse.treasury;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for FxForwardContractAgreement
 */
public interface FxForwardContractAgreementService {

    List<FxForwardContractAgreementDto> getByTenant(UUID tenantId);

    List<FxForwardContractAgreementDto> getByUser(UUID userId);

    FxForwardContractAgreementDto create(FxForwardContractAgreementDto dto);

    FxForwardContractAgreementDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<FxForwardContractAgreementDto> listAll();
}
