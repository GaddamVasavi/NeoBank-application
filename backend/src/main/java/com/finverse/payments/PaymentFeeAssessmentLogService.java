package com.finverse.payments;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for PaymentFeeAssessmentLog
 */
public interface PaymentFeeAssessmentLogService {

    List<PaymentFeeAssessmentLogDto> getByTenant(UUID tenantId);

    List<PaymentFeeAssessmentLogDto> getByUser(UUID userId);

    PaymentFeeAssessmentLogDto create(PaymentFeeAssessmentLogDto dto);

    PaymentFeeAssessmentLogDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<PaymentFeeAssessmentLogDto> listAll();
}
