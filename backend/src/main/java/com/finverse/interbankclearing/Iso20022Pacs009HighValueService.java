package com.finverse.interbankclearing;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for Iso20022Pacs009HighValue
 */
public interface Iso20022Pacs009HighValueService {

    List<Iso20022Pacs009HighValueDto> getByTenant(UUID tenantId);

    List<Iso20022Pacs009HighValueDto> getByUser(UUID userId);

    Iso20022Pacs009HighValueDto create(Iso20022Pacs009HighValueDto dto);

    Iso20022Pacs009HighValueDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<Iso20022Pacs009HighValueDto> listAll();
}
