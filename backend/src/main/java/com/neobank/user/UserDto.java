package com.neobank.user;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.time.Instant; import java.util.Set; import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class UserDto {
    private UUID id;
    private String username;
    private String email;
    private String phoneNumber;
    private UserStatus status;
    private boolean emailVerified;
    private boolean phoneVerified;
    private boolean mfaEnabled;
    private Set<String> roles;
    private ProfileDto profile;
    private UserPreferencesDto preferences;
    private Instant lastLoginAt;
    private Instant createdAt;
}
