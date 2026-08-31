package com.neobank.admin;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CurrencyExchangeSpreadRepository extends JpaRepository<CurrencyExchangeSpread, UUID> {
    List<CurrencyExchangeSpread> findByUserId(UUID userId);
    Optional<CurrencyExchangeSpread> findByRecordKey(String recordKey);
    List<CurrencyExchangeSpread> findByStatus(String status);
}
