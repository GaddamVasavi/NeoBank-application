package com.finverse.kyc;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for KycReviewerDecisionLog
 */
public interface KycReviewerDecisionLogService {

    List<KycReviewerDecisionLogDto> getByTenant(UUID tenantId);

    List<KycReviewerDecisionLogDto> getByUser(UUID userId);

    KycReviewerDecisionLogDto create(KycReviewerDecisionLogDto dto);

    KycReviewerDecisionLogDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<KycReviewerDecisionLogDto> listAll();
}
