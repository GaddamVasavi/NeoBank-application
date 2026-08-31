package com.neobank.support;
import java.util.List; import java.util.UUID;
public interface SupportService {
    List<SupportTicket> getUserTickets(UUID userId);
    SupportTicket createTicket(UUID userId, String subject, String category, String priority, String message);
    List<TicketMessage> getTicketMessages(UUID ticketId);
    TicketMessage replyTicket(UUID ticketId, UUID senderId, String message);
}
