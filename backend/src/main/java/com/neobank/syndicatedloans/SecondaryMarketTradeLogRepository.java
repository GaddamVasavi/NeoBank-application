package com.neobank.syndicatedloans;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface SecondaryMarketTradeLogRepository extends JpaRepository<SecondaryMarketTradeLog, UUID> {
    List<SecondaryMarketTradeLog> findByUserId(UUID userId);
    Optional<SecondaryMarketTradeLog> findByProtocolReference(String ref);
    List<SecondaryMarketTradeLog> findByOperationalState(String state);
}
