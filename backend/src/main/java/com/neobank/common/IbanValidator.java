package com.neobank.common;

import org.springframework.stereotype.Component;

@Component
public class IbanValidator {
    public boolean validate(String iban) {
        if (iban == null) return false;
        String clean = iban.replaceAll("\\s+", "").toUpperCase();
        if (clean.length() < 15 || clean.length() > 34) return false;
        String rearranged = clean.substring(4) + clean.substring(0, 4);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rearranged.length(); i++) {
            char c = rearranged.charAt(i);
            if (Character.isDigit(c)) sb.append(c);
            else if (Character.isLetter(c)) sb.append(c - 'A' + 10);
            else return false;
        }
        int checksum = 0;
        for (int i = 0; i < sb.length(); i++) {
            checksum = (checksum * 10 + (sb.charAt(i) - '0')) % 97;
        }
        return checksum == 1;
    }
}
