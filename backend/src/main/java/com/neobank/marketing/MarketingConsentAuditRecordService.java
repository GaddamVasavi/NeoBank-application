package com.neobank.marketing;
import java.util.List; import java.util.UUID;
public interface MarketingConsentAuditRecordService {
    List<MarketingConsentAuditRecordDto> getByUser(UUID userId);
    MarketingConsentAuditRecordDto create(MarketingConsentAuditRecordDto dto);
    MarketingConsentAuditRecordDto getByCode(String code);
    void updateState(UUID id, String state);
    List<MarketingConsentAuditRecordDto> listAll();
}
