package com.neobank.investment;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface StockOrderExecutionRepository extends JpaRepository<StockOrderExecution, UUID> {
    List<StockOrderExecution> findByUserId(UUID userId);
    Optional<StockOrderExecution> findByIdentifierCode(String code);
    List<StockOrderExecution> findByStatus(String status);
}
