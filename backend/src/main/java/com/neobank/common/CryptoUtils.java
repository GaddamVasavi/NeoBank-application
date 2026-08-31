package com.neobank.common;
import org.apache.commons.codec.digest.DigestUtils;
import java.security.SecureRandom;
import java.util.Base64;
public final class CryptoUtils {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final String NUMERIC_CHARS = "0123456789";
    private CryptoUtils() {}
    public static String sha256Hex(String input) {
        if (input == null) return null;
        return DigestUtils.sha256Hex(input);
    }
    public static String generateSecureToken(int byteLength) {
        byte[] bytes = new byte[byteLength];
        SECURE_RANDOM.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
    public static String generateOtp(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = SECURE_RANDOM.nextInt(NUMERIC_CHARS.length());
            sb.append(NUMERIC_CHARS.charAt(index));
        }
        return sb.toString();
    }
}
