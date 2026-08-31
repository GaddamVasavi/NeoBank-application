package com.neobank.corporate;
import java.util.List; import java.util.UUID;
public interface CorporateTreasuryMandateService {
    List<CorporateTreasuryMandateDto> getByUser(UUID userId);
    CorporateTreasuryMandateDto create(CorporateTreasuryMandateDto dto);
    CorporateTreasuryMandateDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CorporateTreasuryMandateDto> listAll();
}
