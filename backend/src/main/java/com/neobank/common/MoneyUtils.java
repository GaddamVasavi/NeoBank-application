package com.neobank.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public final class MoneyUtils {
    private static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("#,##0.00");

    private MoneyUtils() {}

    public static BigDecimal roundToTwoDecimals(BigDecimal amount) {
        if (amount == null) return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
        return amount.setScale(2, RoundingMode.HALF_EVEN);
    }

    public static String formatCurrency(BigDecimal amount) {
        if (amount == null) return "$0.00";
        return "$" + CURRENCY_FORMAT.format(amount);
    }

    public static boolean isPositive(BigDecimal amount) {
        return amount != null && amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean isZeroOrNegative(BigDecimal amount) {
        return amount == null || amount.compareTo(BigDecimal.ZERO) <= 0;
    }
}
