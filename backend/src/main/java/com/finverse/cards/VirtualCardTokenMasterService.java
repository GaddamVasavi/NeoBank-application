package com.finverse.cards;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for VirtualCardTokenMaster
 */
public interface VirtualCardTokenMasterService {

    List<VirtualCardTokenMasterDto> getByTenant(UUID tenantId);

    List<VirtualCardTokenMasterDto> getByUser(UUID userId);

    VirtualCardTokenMasterDto create(VirtualCardTokenMasterDto dto);

    VirtualCardTokenMasterDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<VirtualCardTokenMasterDto> listAll();
}
