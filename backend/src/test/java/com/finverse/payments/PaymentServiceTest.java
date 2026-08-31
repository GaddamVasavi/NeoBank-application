package com.finverse.payments;
import org.junit.jupiter.api.Test; import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
public class PaymentServiceTest {
    @Test void testIdempotencyKeyGeneration() {
        String key1 = UUID.randomUUID().toString();
        String key2 = UUID.randomUUID().toString();
        assertNotEquals(key1, key2);
    }
}
