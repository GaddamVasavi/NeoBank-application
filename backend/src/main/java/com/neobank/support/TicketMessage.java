package com.neobank.support;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
@Entity @Table(name = "ticket_messages") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class TicketMessage extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "ticket_id", nullable = false) private SupportTicket ticket;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "sender_id", nullable = false) private User sender;
    @Column(name = "message", nullable = false, columnDefinition = "TEXT") private String message;
    @Column(name = "is_internal", nullable = false) @Builder.Default private boolean internal = false;
}
