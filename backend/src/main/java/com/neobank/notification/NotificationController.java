package com.neobank.notification;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/notifications") @RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    @GetMapping public ResponseEntity<ApiResponse<List<Notification>>> getNotifications() { return ResponseEntity.ok(ApiResponse.success(notificationService.getUserNotifications(SecurityUtils.getCurrentUserId()))); }
    @PatchMapping("/{id}/read") public ResponseEntity<ApiResponse<Void>> markRead(@PathVariable UUID id) { notificationService.markAsRead(SecurityUtils.getCurrentUserId(), id); return ResponseEntity.ok(ApiResponse.success(null, "Marked as read")); }
}
