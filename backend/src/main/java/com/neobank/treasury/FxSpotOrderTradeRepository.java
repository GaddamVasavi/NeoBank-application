package com.neobank.treasury;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface FxSpotOrderTradeRepository extends JpaRepository<FxSpotOrderTrade, UUID> {
    List<FxSpotOrderTrade> findByUserId(UUID userId);
    Optional<FxSpotOrderTrade> findByIdentifierCode(String code);
    List<FxSpotOrderTrade> findByStatus(String status);
}
