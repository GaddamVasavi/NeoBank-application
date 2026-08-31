package com.neobank.notification;
import java.util.List; import java.util.UUID;
public interface NotificationService {
    List<Notification> getUserNotifications(UUID userId);
    void markAsRead(UUID userId, UUID notificationId);
    void sendNotification(UUID userId, String title, String message, String type);
}
