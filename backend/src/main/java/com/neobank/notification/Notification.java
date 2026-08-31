package com.neobank.notification;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.time.Instant;
@Entity @Table(name = "notifications") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Notification extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "title", nullable = false, length = 150) private String title;
    @Column(name = "message", nullable = false, columnDefinition = "TEXT") private String message;
    @Column(name = "notification_type", nullable = false, length = 50) @Builder.Default private String notificationType = "SYSTEM";
    @Column(name = "channel", nullable = false, length = 30) @Builder.Default private String channel = "IN_APP";
    @Column(name = "is_read", nullable = false) @Builder.Default private boolean read = false;
    @Column(name = "read_at") private Instant readAt;
}
