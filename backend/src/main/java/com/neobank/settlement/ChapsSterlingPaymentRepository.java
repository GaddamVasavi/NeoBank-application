package com.neobank.settlement;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ChapsSterlingPaymentRepository extends JpaRepository<ChapsSterlingPayment, UUID> {
    List<ChapsSterlingPayment> findByUserId(UUID userId);
    Optional<ChapsSterlingPayment> findBySettlementRef(String ref);
    List<ChapsSterlingPayment> findByLifecycleStatus(String status);
}
