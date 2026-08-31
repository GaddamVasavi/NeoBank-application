package com.neobank.auditstream;
import java.util.List; import java.util.UUID;
public interface RegulatoryEvidencePackageService {
    List<RegulatoryEvidencePackageDto> getByUser(UUID userId);
    RegulatoryEvidencePackageDto create(RegulatoryEvidencePackageDto dto);
    RegulatoryEvidencePackageDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<RegulatoryEvidencePackageDto> listAll();
}
