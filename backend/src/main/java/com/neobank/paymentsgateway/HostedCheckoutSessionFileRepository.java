package com.neobank.paymentsgateway;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface HostedCheckoutSessionFileRepository extends JpaRepository<HostedCheckoutSessionFile, UUID> {
    List<HostedCheckoutSessionFile> findByUserId(UUID userId);
    Optional<HostedCheckoutSessionFile> findBySystemIdentifier(String id);
    List<HostedCheckoutSessionFile> findByValidationState(String state);
}
