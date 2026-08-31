package com.neobank.settlement;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface LiquidityBufferAllocationRepository extends JpaRepository<LiquidityBufferAllocation, UUID> {
    List<LiquidityBufferAllocation> findByUserId(UUID userId);
    Optional<LiquidityBufferAllocation> findBySettlementRef(String ref);
    List<LiquidityBufferAllocation> findByLifecycleStatus(String status);
}
