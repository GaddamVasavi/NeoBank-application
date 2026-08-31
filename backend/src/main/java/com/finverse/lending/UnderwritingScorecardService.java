package com.finverse.lending;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for UnderwritingScorecard
 */
public interface UnderwritingScorecardService {

    List<UnderwritingScorecardDto> getByTenant(UUID tenantId);

    List<UnderwritingScorecardDto> getByUser(UUID userId);

    UnderwritingScorecardDto create(UnderwritingScorecardDto dto);

    UnderwritingScorecardDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<UnderwritingScorecardDto> listAll();
}
