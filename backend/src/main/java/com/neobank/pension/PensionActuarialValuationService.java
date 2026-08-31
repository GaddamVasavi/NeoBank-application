package com.neobank.pension;
import java.util.List; import java.util.UUID;
public interface PensionActuarialValuationService {
    List<PensionActuarialValuationDto> getByUser(UUID userId);
    PensionActuarialValuationDto create(PensionActuarialValuationDto dto);
    PensionActuarialValuationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<PensionActuarialValuationDto> listAll();
}
