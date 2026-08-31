package com.finverse.support;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CustomerSupportTicket
 */
public interface CustomerSupportTicketService {

    List<CustomerSupportTicketDto> getByTenant(UUID tenantId);

    List<CustomerSupportTicketDto> getByUser(UUID userId);

    CustomerSupportTicketDto create(CustomerSupportTicketDto dto);

    CustomerSupportTicketDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CustomerSupportTicketDto> listAll();
}
