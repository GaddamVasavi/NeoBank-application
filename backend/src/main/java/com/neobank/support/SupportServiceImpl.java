package com.neobank.support;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.util.List; import java.util.UUID;
@Service @RequiredArgsConstructor
public class SupportServiceImpl implements SupportService {
    private final SupportTicketRepository ticketRepository; private final TicketMessageRepository messageRepository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<SupportTicket> getUserTickets(UUID userId) { return ticketRepository.findByUserIdOrderByCreatedAtDesc(userId); }
    @Override @Transactional
    public SupportTicket createTicket(UUID userId, String subject, String category, String priority, String message) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        String num = "TKT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        SupportTicket t = SupportTicket.builder().user(user).ticketNumber(num).subject(subject).category(category).priority(priority).status("OPEN").build();
        SupportTicket saved = ticketRepository.save(t);
        TicketMessage tm = TicketMessage.builder().ticket(saved).sender(user).message(message).build();
        messageRepository.save(tm);
        return saved;
    }
    @Override @Transactional(readOnly = true) public List<TicketMessage> getTicketMessages(UUID ticketId) { return messageRepository.findByTicketIdOrderByCreatedAtAsc(ticketId); }
    @Override @Transactional
    public TicketMessage replyTicket(UUID ticketId, UUID senderId, String message) {
        SupportTicket t = ticketRepository.findById(ticketId).orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
        User sender = userRepository.findById(senderId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        TicketMessage tm = TicketMessage.builder().ticket(t).sender(sender).message(message).build();
        return messageRepository.save(tm);
    }
}
