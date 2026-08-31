package com.neobank.commercial;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TradeFinanceShipmentRepository extends JpaRepository<TradeFinanceShipment, UUID> {
    List<TradeFinanceShipment> findByUserId(UUID userId);
    Optional<TradeFinanceShipment> findByIdentifierCode(String code);
    List<TradeFinanceShipment> findByStatus(String status);
}
