package com.neobank.governance;
import java.util.List; import java.util.UUID;
public interface CorporateGovernanceCharterService {
    List<CorporateGovernanceCharterDto> getByUser(UUID userId);
    CorporateGovernanceCharterDto create(CorporateGovernanceCharterDto dto);
    CorporateGovernanceCharterDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CorporateGovernanceCharterDto> listAll();
}
