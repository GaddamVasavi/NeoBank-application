package com.finverse.privateequity;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CapitalCallDrawdownNotice
 */
public interface CapitalCallDrawdownNoticeService {

    List<CapitalCallDrawdownNoticeDto> getByTenant(UUID tenantId);

    List<CapitalCallDrawdownNoticeDto> getByUser(UUID userId);

    CapitalCallDrawdownNoticeDto create(CapitalCallDrawdownNoticeDto dto);

    CapitalCallDrawdownNoticeDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CapitalCallDrawdownNoticeDto> listAll();
}
