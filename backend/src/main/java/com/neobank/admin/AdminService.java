package com.neobank.admin;
import com.neobank.user.User; import java.util.List; import java.util.Map; import java.util.UUID;
public interface AdminService {
    Map<String, Object> getSystemStats();
    List<User> getAllUsers();
    void updateUserStatus(UUID userId, String status);
}
