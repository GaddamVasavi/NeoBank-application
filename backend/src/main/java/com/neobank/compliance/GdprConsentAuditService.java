package com.neobank.compliance;
import java.util.List; import java.util.UUID;
public interface GdprConsentAuditService {
    List<GdprConsentAuditDto> getByUser(UUID userId);
    GdprConsentAuditDto create(GdprConsentAuditDto dto);
    GdprConsentAuditDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<GdprConsentAuditDto> listAll();
}
