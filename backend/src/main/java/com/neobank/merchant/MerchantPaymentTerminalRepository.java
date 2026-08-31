package com.neobank.merchant;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MerchantPaymentTerminalRepository extends JpaRepository<MerchantPaymentTerminal, UUID> {
    List<MerchantPaymentTerminal> findByUserId(UUID userId);
    Optional<MerchantPaymentTerminal> findByCoreReference(String ref);
    List<MerchantPaymentTerminal> findByProcessingStatus(String status);
}
