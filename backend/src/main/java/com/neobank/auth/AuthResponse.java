package com.neobank.auth;
import com.fasterxml.jackson.annotation.JsonInclude; import com.neobank.user.UserDto; import lombok.*;
import java.util.Set;
@Data @Builder @NoArgsConstructor @AllArgsConstructor @JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {
    private String accessToken;
    private String refreshToken;
    @Builder.Default private String tokenType = "Bearer";
    private long expiresInMs;
    private boolean mfaRequired;
    private String mfaSessionToken;
    private Set<String> roles;
    private UserDto user;
}
