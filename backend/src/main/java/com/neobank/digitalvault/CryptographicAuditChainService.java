package com.neobank.digitalvault;
import java.util.List; import java.util.UUID;
public interface CryptographicAuditChainService {
    List<CryptographicAuditChainDto> getByUser(UUID userId);
    CryptographicAuditChainDto create(CryptographicAuditChainDto dto);
    CryptographicAuditChainDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<CryptographicAuditChainDto> listAll();
}
