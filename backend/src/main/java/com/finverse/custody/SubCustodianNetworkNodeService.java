package com.finverse.custody;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SubCustodianNetworkNode
 */
public interface SubCustodianNetworkNodeService {

    List<SubCustodianNetworkNodeDto> getByTenant(UUID tenantId);

    List<SubCustodianNetworkNodeDto> getByUser(UUID userId);

    SubCustodianNetworkNodeDto create(SubCustodianNetworkNodeDto dto);

    SubCustodianNetworkNodeDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SubCustodianNetworkNodeDto> listAll();
}
