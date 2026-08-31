package com.neobank.factoring;
import java.util.List; import java.util.UUID;
public interface FactoringFeeCalculationService {
    List<FactoringFeeCalculationDto> getByUser(UUID userId);
    FactoringFeeCalculationDto create(FactoringFeeCalculationDto dto);
    FactoringFeeCalculationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<FactoringFeeCalculationDto> listAll();
}
