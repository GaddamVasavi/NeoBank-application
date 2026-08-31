package com.neobank.auditstream;
import java.util.List; import java.util.UUID;
public interface CryptographicAuditSealService {
    List<CryptographicAuditSealDto> getByUser(UUID userId);
    CryptographicAuditSealDto create(CryptographicAuditSealDto dto);
    CryptographicAuditSealDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CryptographicAuditSealDto> listAll();
}
