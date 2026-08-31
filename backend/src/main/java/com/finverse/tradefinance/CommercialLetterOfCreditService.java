package com.finverse.tradefinance;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CommercialLetterOfCredit
 */
public interface CommercialLetterOfCreditService {

    List<CommercialLetterOfCreditDto> getByTenant(UUID tenantId);

    List<CommercialLetterOfCreditDto> getByUser(UUID userId);

    CommercialLetterOfCreditDto create(CommercialLetterOfCreditDto dto);

    CommercialLetterOfCreditDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CommercialLetterOfCreditDto> listAll();
}
