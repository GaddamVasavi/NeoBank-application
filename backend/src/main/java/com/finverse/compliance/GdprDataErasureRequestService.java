package com.finverse.compliance;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for GdprDataErasureRequest
 */
public interface GdprDataErasureRequestService {

    List<GdprDataErasureRequestDto> getByTenant(UUID tenantId);

    List<GdprDataErasureRequestDto> getByUser(UUID userId);

    GdprDataErasureRequestDto create(GdprDataErasureRequestDto dto);

    GdprDataErasureRequestDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<GdprDataErasureRequestDto> listAll();
}
