package com.neobank.support;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/support") @RequiredArgsConstructor
public class SupportController {
    private final SupportService supportService;
    @GetMapping("/tickets") public ResponseEntity<ApiResponse<List<SupportTicket>>> getTickets() { return ResponseEntity.ok(ApiResponse.success(supportService.getUserTickets(SecurityUtils.getCurrentUserId()))); }
    @PostMapping("/tickets") public ResponseEntity<ApiResponse<SupportTicket>> createTicket(@RequestParam String subject, @RequestParam String category, @RequestParam(defaultValue = "MEDIUM") String priority, @RequestParam String message) { return ResponseEntity.ok(ApiResponse.success(supportService.createTicket(SecurityUtils.getCurrentUserId(), subject, category, priority, message), "Ticket created")); }
    @GetMapping("/tickets/{ticketId}/messages") public ResponseEntity<ApiResponse<List<TicketMessage>>> getMessages(@PathVariable UUID ticketId) { return ResponseEntity.ok(ApiResponse.success(supportService.getTicketMessages(ticketId))); }
    @PostMapping("/tickets/{ticketId}/reply") public ResponseEntity<ApiResponse<TicketMessage>> replyTicket(@PathVariable UUID ticketId, @RequestParam String message) { return ResponseEntity.ok(ApiResponse.success(supportService.replyTicket(ticketId, SecurityUtils.getCurrentUserId(), message), "Reply sent")); }
}
