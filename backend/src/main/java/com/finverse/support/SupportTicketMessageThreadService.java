package com.finverse.support;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for SupportTicketMessageThread
 */
public interface SupportTicketMessageThreadService {

    List<SupportTicketMessageThreadDto> getByTenant(UUID tenantId);

    List<SupportTicketMessageThreadDto> getByUser(UUID userId);

    SupportTicketMessageThreadDto create(SupportTicketMessageThreadDto dto);

    SupportTicketMessageThreadDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<SupportTicketMessageThreadDto> listAll();
}
