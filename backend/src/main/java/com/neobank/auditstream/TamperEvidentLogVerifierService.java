package com.neobank.auditstream;
import java.util.List; import java.util.UUID;
public interface TamperEvidentLogVerifierService {
    List<TamperEvidentLogVerifierDto> getByUser(UUID userId);
    TamperEvidentLogVerifierDto create(TamperEvidentLogVerifierDto dto);
    TamperEvidentLogVerifierDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<TamperEvidentLogVerifierDto> listAll();
}
