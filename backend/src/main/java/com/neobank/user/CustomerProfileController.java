package com.neobank.user;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import jakarta.validation.Valid; import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/v1/profile") @RequiredArgsConstructor
public class CustomerProfileController {
    private final ProfileService profileService;
    @GetMapping public ResponseEntity<ApiResponse<ProfileDto>> getProfile() { return ResponseEntity.ok(ApiResponse.success(profileService.getProfileByUserId(SecurityUtils.getCurrentUserId()))); }
    @PutMapping public ResponseEntity<ApiResponse<ProfileDto>> updateProfile(@Valid @RequestBody UpdateProfileRequest request) { return ResponseEntity.ok(ApiResponse.success(profileService.updateProfile(SecurityUtils.getCurrentUserId(), request), "Profile updated")); }
}
