package com.finverse.transfers;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SepaInstantCreditTransfer
 */
public interface SepaInstantCreditTransferService {

    List<SepaInstantCreditTransferDto> getByTenant(UUID tenantId);

    List<SepaInstantCreditTransferDto> getByUser(UUID userId);

    SepaInstantCreditTransferDto create(SepaInstantCreditTransferDto dto);

    SepaInstantCreditTransferDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SepaInstantCreditTransferDto> listAll();
}
