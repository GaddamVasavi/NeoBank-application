package com.neobank.corporate;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MultiCurrencyNotionalPoolRepository extends JpaRepository<MultiCurrencyNotionalPool, UUID> {
    List<MultiCurrencyNotionalPool> findByUserId(UUID userId);
    Optional<MultiCurrencyNotionalPool> findByTrackingCode(String code);
    List<MultiCurrencyNotionalPool> findByStateFlag(String stateFlag);
}
