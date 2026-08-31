package com.neobank.privateequity;
import java.util.List; import java.util.UUID;
public interface ManagementFeeCalculationService {
    List<ManagementFeeCalculationDto> getByUser(UUID userId);
    ManagementFeeCalculationDto create(ManagementFeeCalculationDto dto);
    ManagementFeeCalculationDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<ManagementFeeCalculationDto> listAll();
}
