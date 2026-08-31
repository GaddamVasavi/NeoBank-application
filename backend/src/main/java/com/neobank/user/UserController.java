package com.neobank.user;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import jakarta.validation.Valid; import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/users") @RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/me") public ResponseEntity<ApiResponse<UserDto>> getCurrentUser() { return ResponseEntity.ok(ApiResponse.success(userService.getCurrentUser())); }
    @PostMapping("/change-password") public ResponseEntity<ApiResponse<Void>> changePassword(@Valid @RequestBody ChangePasswordRequest request) {
        userService.changePassword(SecurityUtils.getCurrentUserId(), request);
        return ResponseEntity.ok(ApiResponse.success(null, "Password changed successfully"));
    }
    @GetMapping("/preferences") public ResponseEntity<ApiResponse<UserPreferencesDto>> getPreferences() { return ResponseEntity.ok(ApiResponse.success(userService.getUserPreferences(SecurityUtils.getCurrentUserId()))); }
    @PutMapping("/preferences") public ResponseEntity<ApiResponse<UserPreferencesDto>> updatePreferences(@RequestBody UserPreferencesDto preferencesDto) { return ResponseEntity.ok(ApiResponse.success(userService.updatePreferences(SecurityUtils.getCurrentUserId(), preferencesDto), "Preferences updated")); }
    @GetMapping("/addresses") public ResponseEntity<ApiResponse<List<AddressDto>>> getAddresses() { return ResponseEntity.ok(ApiResponse.success(userService.getUserAddresses(SecurityUtils.getCurrentUserId()))); }
    @PostMapping("/addresses") public ResponseEntity<ApiResponse<AddressDto>> addAddress(@Valid @RequestBody AddressDto addressDto) { return ResponseEntity.ok(ApiResponse.success(userService.addAddress(SecurityUtils.getCurrentUserId(), addressDto), "Address added")); }
    @DeleteMapping("/addresses/{addressId}") public ResponseEntity<ApiResponse<Void>> deleteAddress(@PathVariable UUID addressId) { userService.deleteAddress(SecurityUtils.getCurrentUserId(), addressId); return ResponseEntity.ok(ApiResponse.success(null, "Address deleted")); }
}
