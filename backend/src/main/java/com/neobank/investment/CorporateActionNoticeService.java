package com.neobank.investment;
import java.util.List; import java.util.UUID;
public interface CorporateActionNoticeService {
    List<CorporateActionNoticeDto> getByUser(UUID userId);
    CorporateActionNoticeDto create(CorporateActionNoticeDto dto);
    CorporateActionNoticeDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<CorporateActionNoticeDto> listAll();
}
