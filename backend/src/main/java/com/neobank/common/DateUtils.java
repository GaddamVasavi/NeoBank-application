package com.neobank.common;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class DateUtils {
    public static final DateTimeFormatter ISO_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter HUMAN_DATE_FORMAT = DateTimeFormatter.ofPattern("MMM dd, yyyy");

    private DateUtils() {}

    public static LocalDate toLocalDate(Instant instant) {
        if (instant == null) return null;
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static String formatHuman(Instant instant) {
        if (instant == null) return "N/A";
        return toLocalDate(instant).format(HUMAN_DATE_FORMAT);
    }
}
