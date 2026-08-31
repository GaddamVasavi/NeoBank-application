package com.neobank.fxrates;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CurrencyBasketAllocationRepository extends JpaRepository<CurrencyBasketAllocation, UUID> {
    List<CurrencyBasketAllocation> findByUserId(UUID userId);
    Optional<CurrencyBasketAllocation> findByRegistryKey(String key);
    List<CurrencyBasketAllocation> findByDeliveryStatus(String status);
}
