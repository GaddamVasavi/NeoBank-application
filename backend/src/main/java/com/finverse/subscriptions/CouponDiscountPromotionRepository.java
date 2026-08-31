package com.finverse.subscriptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for CouponDiscountPromotion
 */
@Repository
public interface CouponDiscountPromotionRepository extends JpaRepository<CouponDiscountPromotion, UUID> {

    List<CouponDiscountPromotion> findByTenantId(UUID tenantId);

    List<CouponDiscountPromotion> findByUserId(UUID userId);

    Optional<CouponDiscountPromotion> findBySystemReference(String ref);

    List<CouponDiscountPromotion> findByOperationalStatus(String status);

    @Query("SELECT e FROM CouponDiscountPromotion e WHERE e.tenantId = :tenantId AND e.operationalStatus = :status")
    List<CouponDiscountPromotion> findActiveByTenant(@Param("tenantId") UUID tenantId, @Param("status") String status);
}
