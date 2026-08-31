package com.finverse.custody;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CorporateActionProxyVote
 */
public interface CorporateActionProxyVoteService {

    List<CorporateActionProxyVoteDto> getByTenant(UUID tenantId);

    List<CorporateActionProxyVoteDto> getByUser(UUID userId);

    CorporateActionProxyVoteDto create(CorporateActionProxyVoteDto dto);

    CorporateActionProxyVoteDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CorporateActionProxyVoteDto> listAll();
}
