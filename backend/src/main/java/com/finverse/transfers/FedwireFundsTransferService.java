package com.finverse.transfers;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for FedwireFundsTransfer
 */
public interface FedwireFundsTransferService {

    List<FedwireFundsTransferDto> getByTenant(UUID tenantId);

    List<FedwireFundsTransferDto> getByUser(UUID userId);

    FedwireFundsTransferDto create(FedwireFundsTransferDto dto);

    FedwireFundsTransferDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<FedwireFundsTransferDto> listAll();
}
