package com.neobank.compliance;
import java.util.List; import java.util.UUID;
public interface RegulatoryFilingPackageService {
    List<RegulatoryFilingPackageDto> getByUser(UUID userId);
    RegulatoryFilingPackageDto create(RegulatoryFilingPackageDto dto);
    RegulatoryFilingPackageDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<RegulatoryFilingPackageDto> listAll();
}
