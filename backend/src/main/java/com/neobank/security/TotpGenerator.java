package com.neobank.security;

import org.apache.commons.codec.binary.Base32;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

@Component
public class TotpGenerator {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final Base32 BASE32 = new Base32();

    public String generateSecret() {
        byte[] bytes = new byte[20];
        RANDOM.nextBytes(bytes);
        return BASE32.encodeToString(bytes);
    }

    public boolean verifyCode(String secret, int code) {
        long currentBucket = System.currentTimeMillis() / 1000 / 30;
        for (int i = -1; i <= 1; i++) {
            if (generateCodeForBucket(secret, currentBucket + i) == code) {
                return true;
            }
        }
        return false;
    }

    private int generateCodeForBucket(String secret, long bucket) {
        try {
            byte[] key = BASE32.decode(secret);
            byte[] data = new byte[8];
            long value = bucket;
            for (int i = 8; i-- > 0; value >>>= 8) {
                data[i] = (byte) value;
            }
            SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signKey);
            byte[] hash = mac.doFinal(data);
            int offset = hash[hash.length - 1] & 0xF;
            long truncatedHash = 0;
            for (int i = 0; i < 4; ++i) {
                truncatedHash <<= 8;
                truncatedHash |= (hash[offset + i] & 0xFF);
            }
            truncatedHash &= 0x7FFFFFFF;
            truncatedHash %= 1000000;
            return (int) truncatedHash;
        } catch (Exception e) {
            return -1;
        }
    }
}
