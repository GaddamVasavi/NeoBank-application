package com.finverse.subscriptions;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CouponDiscountPromotion
 */
public interface CouponDiscountPromotionService {

    List<CouponDiscountPromotionDto> getByTenant(UUID tenantId);

    List<CouponDiscountPromotionDto> getByUser(UUID userId);

    CouponDiscountPromotionDto create(CouponDiscountPromotionDto dto);

    CouponDiscountPromotionDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CouponDiscountPromotionDto> listAll();
}
