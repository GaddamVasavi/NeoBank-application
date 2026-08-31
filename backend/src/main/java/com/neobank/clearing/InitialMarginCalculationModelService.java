package com.neobank.clearing;
import java.util.List; import java.util.UUID;
public interface InitialMarginCalculationModelService {
    List<InitialMarginCalculationModelDto> getByUser(UUID userId);
    InitialMarginCalculationModelDto create(InitialMarginCalculationModelDto dto);
    InitialMarginCalculationModelDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<InitialMarginCalculationModelDto> listAll();
}
