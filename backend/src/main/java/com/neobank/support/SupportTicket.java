package com.neobank.support;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.util.UUID;
@Entity @Table(name = "support_tickets") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class SupportTicket extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "ticket_number", nullable = false, unique = true, length = 36) private String ticketNumber;
    @Column(name = "subject", nullable = false, length = 200) private String subject;
    @Column(name = "category", nullable = false, length = 50) @Builder.Default private String category = "GENERAL";
    @Column(name = "priority", nullable = false, length = 20) @Builder.Default private String priority = "MEDIUM";
    @Column(name = "status", nullable = false, length = 30) @Builder.Default private String status = "OPEN";
    @Column(name = "assigned_agent_id") private UUID assignedAgentId;
}
