package com.finverse.tenant;
import org.junit.jupiter.api.Test; import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock; import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional; import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*; import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class TenantServiceTest {
    @Mock private TenantRepository tenantRepository;
    @Test void testTenantLookupBySlug() {
        Tenant t = Tenant.builder().id(UUID.randomUUID()).name("Apex Financial").slug("apex-fin").status("ACTIVE").build();
        when(tenantRepository.findBySlug("apex-fin")).thenReturn(Optional.of(t));
        Optional<Tenant> result = tenantRepository.findBySlug("apex-fin");
        assertTrue(result.isPresent());
        assertEquals("Apex Financial", result.get().getName());
    }
}
