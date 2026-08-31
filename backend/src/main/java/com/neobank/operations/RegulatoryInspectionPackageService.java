package com.neobank.operations;
import java.util.List; import java.util.UUID;
public interface RegulatoryInspectionPackageService {
    List<RegulatoryInspectionPackageDto> getByUser(UUID userId);
    RegulatoryInspectionPackageDto create(RegulatoryInspectionPackageDto dto);
    RegulatoryInspectionPackageDto getByCode(String code);
    void updateState(UUID id, String state);
    List<RegulatoryInspectionPackageDto> listAll();
}
