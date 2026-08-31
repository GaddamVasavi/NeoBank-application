package com.neobank.fx;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AutomatedFxOrderBookRepository extends JpaRepository<AutomatedFxOrderBook, UUID> {
    List<AutomatedFxOrderBook> findByUserId(UUID userId);
    Optional<AutomatedFxOrderBook> findBySettlementRef(String ref);
    List<AutomatedFxOrderBook> findByLifecycleStatus(String status);
}
