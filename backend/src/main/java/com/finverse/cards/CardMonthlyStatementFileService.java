package com.finverse.cards;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CardMonthlyStatementFile
 */
public interface CardMonthlyStatementFileService {

    List<CardMonthlyStatementFileDto> getByTenant(UUID tenantId);

    List<CardMonthlyStatementFileDto> getByUser(UUID userId);

    CardMonthlyStatementFileDto create(CardMonthlyStatementFileDto dto);

    CardMonthlyStatementFileDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CardMonthlyStatementFileDto> listAll();
}
