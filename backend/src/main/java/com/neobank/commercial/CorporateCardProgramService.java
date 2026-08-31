package com.neobank.commercial;
import java.util.List; import java.util.UUID;
public interface CorporateCardProgramService {
    List<CorporateCardProgramDto> getByUser(UUID userId);
    CorporateCardProgramDto create(CorporateCardProgramDto dto);
    CorporateCardProgramDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<CorporateCardProgramDto> listAll();
}
