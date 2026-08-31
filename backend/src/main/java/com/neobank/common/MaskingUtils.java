package com.neobank.common;

public final class MaskingUtils {
    private MaskingUtils() {}

    public static String maskAccountNumber(String accNumber) {
        if (accNumber == null || accNumber.length() < 4) return "••••";
        return "••••" + accNumber.substring(accNumber.length() - 4);
    }

    public static String maskEmail(String email) {
        if (email == null || !email.contains("@")) return "••••@••••.com";
        String[] parts = email.split("@");
        String name = parts[0];
        String domain = parts[1];
        if (name.length() <= 2) return name.charAt(0) + "•••@" + domain;
        return name.charAt(0) + "•••" + name.charAt(name.length() - 1) + "@" + domain;
    }

    public static String maskCardNumber(String card) {
        if (card == null || card.length() < 4) return "•••• •••• •••• ••••";
        return "•••• •••• •••• " + card.substring(card.length() - 4);
    }
}
