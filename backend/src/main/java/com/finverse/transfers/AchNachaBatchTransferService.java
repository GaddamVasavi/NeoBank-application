package com.finverse.transfers;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for AchNachaBatchTransfer
 */
public interface AchNachaBatchTransferService {

    List<AchNachaBatchTransferDto> getByTenant(UUID tenantId);

    List<AchNachaBatchTransferDto> getByUser(UUID userId);

    AchNachaBatchTransferDto create(AchNachaBatchTransferDto dto);

    AchNachaBatchTransferDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<AchNachaBatchTransferDto> listAll();
}
