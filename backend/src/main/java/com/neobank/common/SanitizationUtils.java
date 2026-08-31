package com.neobank.common;

import org.apache.commons.lang3.StringUtils;

public final class SanitizationUtils {
    private SanitizationUtils() {}

    public static String sanitizeString(String input) {
        if (input == null) return null;
        return input.replaceAll("[<>\"'&]", "").trim();
    }

    public static String normalizeEmail(String email) {
        if (email == null) return null;
        return email.toLowerCase().trim();
    }

    public static String normalizeUsername(String username) {
        if (username == null) return null;
        return username.toLowerCase().trim();
    }
}
