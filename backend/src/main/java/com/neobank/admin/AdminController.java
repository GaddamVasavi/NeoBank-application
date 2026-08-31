package com.neobank.admin;
import com.neobank.common.ApiResponse; import com.neobank.user.User;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.Map; import java.util.UUID;
@RestController @RequestMapping("/api/v1/admin") @RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    @GetMapping("/stats") public ResponseEntity<ApiResponse<Map<String, Object>>> getStats() { return ResponseEntity.ok(ApiResponse.success(adminService.getSystemStats())); }
    @GetMapping("/users") public ResponseEntity<ApiResponse<List<User>>> getUsers() { return ResponseEntity.ok(ApiResponse.success(adminService.getAllUsers())); }
    @PatchMapping("/users/{userId}/status") public ResponseEntity<ApiResponse<Void>> setStatus(@PathVariable UUID userId, @RequestParam String status) { adminService.updateUserStatus(userId, status); return ResponseEntity.ok(ApiResponse.success(null, "Status updated")); }
}
