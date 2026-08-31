package com.neobank.commercial;
import java.util.List; import java.util.UUID;
public interface CorporateEntityProfileService {
    List<CorporateEntityProfileDto> getByUser(UUID userId);
    CorporateEntityProfileDto create(CorporateEntityProfileDto dto);
    CorporateEntityProfileDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<CorporateEntityProfileDto> listAll();
}
