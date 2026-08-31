package com.neobank.carboncredits;
import java.util.List; import java.util.UUID;
public interface SustainabilityLinkedBondService {
    List<SustainabilityLinkedBondDto> getByUser(UUID userId);
    SustainabilityLinkedBondDto create(SustainabilityLinkedBondDto dto);
    SustainabilityLinkedBondDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<SustainabilityLinkedBondDto> listAll();
}
