package com.neobank.notification;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID;
@Service @RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<Notification> getUserNotifications(UUID userId) { return notificationRepository.findByUserIdOrderByCreatedAtDesc(userId); }
    @Override @Transactional
    public void markAsRead(UUID userId, UUID notificationId) {
        Notification n = notificationRepository.findById(notificationId).orElseThrow(() -> new ResourceNotFoundException("Notification not found"));
        if (n.getUser().getId().equals(userId)) { n.setRead(true); n.setReadAt(Instant.now()); notificationRepository.save(n); }
    }
    @Override @Transactional
    public void sendNotification(UUID userId, String title, String message, String type) {
        User u = userRepository.findById(userId).orElse(null);
        if (u != null) { Notification n = Notification.builder().user(u).title(title).message(message).notificationType(type).build(); notificationRepository.save(n); }
    }
}
