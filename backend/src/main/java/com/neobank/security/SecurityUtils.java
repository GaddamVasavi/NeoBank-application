package com.neobank.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;

public final class SecurityUtils {
    private SecurityUtils() {}

    public static Optional<UserPrincipal> getCurrentUserPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || !(authentication.getPrincipal() instanceof UserPrincipal)) {
            return Optional.empty();
        }
        return Optional.of((UserPrincipal) authentication.getPrincipal());
    }

    public static UUID getCurrentUserId() {
        return getCurrentUserPrincipal().map(UserPrincipal::getId).orElse(null);
    }

    public static String getCurrentUsername() {
        return getCurrentUserPrincipal().map(UserPrincipal::getUsername).orElse(null);
    }
}
