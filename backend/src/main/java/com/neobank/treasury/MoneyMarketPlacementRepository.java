package com.neobank.treasury;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MoneyMarketPlacementRepository extends JpaRepository<MoneyMarketPlacement, UUID> {
    List<MoneyMarketPlacement> findByUserId(UUID userId);
    Optional<MoneyMarketPlacement> findByIdentifierCode(String code);
    List<MoneyMarketPlacement> findByStatus(String status);
}
