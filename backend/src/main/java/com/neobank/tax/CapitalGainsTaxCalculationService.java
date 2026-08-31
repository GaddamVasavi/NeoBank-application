package com.neobank.tax;
import java.util.List; import java.util.UUID;
public interface CapitalGainsTaxCalculationService {
    List<CapitalGainsTaxCalculationDto> getByUser(UUID userId);
    CapitalGainsTaxCalculationDto create(CapitalGainsTaxCalculationDto dto);
    CapitalGainsTaxCalculationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CapitalGainsTaxCalculationDto> listAll();
}
