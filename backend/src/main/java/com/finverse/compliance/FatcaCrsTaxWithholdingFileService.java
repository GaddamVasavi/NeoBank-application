package com.finverse.compliance;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for FatcaCrsTaxWithholdingFile
 */
public interface FatcaCrsTaxWithholdingFileService {

    List<FatcaCrsTaxWithholdingFileDto> getByTenant(UUID tenantId);

    List<FatcaCrsTaxWithholdingFileDto> getByUser(UUID userId);

    FatcaCrsTaxWithholdingFileDto create(FatcaCrsTaxWithholdingFileDto dto);

    FatcaCrsTaxWithholdingFileDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<FatcaCrsTaxWithholdingFileDto> listAll();
}
