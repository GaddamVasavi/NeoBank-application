package com.finverse.transfers;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SwiftGpiCrossBorderTransfer
 */
public interface SwiftGpiCrossBorderTransferService {

    List<SwiftGpiCrossBorderTransferDto> getByTenant(UUID tenantId);

    List<SwiftGpiCrossBorderTransferDto> getByUser(UUID userId);

    SwiftGpiCrossBorderTransferDto create(SwiftGpiCrossBorderTransferDto dto);

    SwiftGpiCrossBorderTransferDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SwiftGpiCrossBorderTransferDto> listAll();
}
