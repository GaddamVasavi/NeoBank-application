package com.neobank.investment;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PortfolioHoldingRepository extends JpaRepository<PortfolioHolding, UUID> {
    List<PortfolioHolding> findByUserId(UUID userId);
    Optional<PortfolioHolding> findByIdentifierCode(String code);
    List<PortfolioHolding> findByStatus(String status);
}
