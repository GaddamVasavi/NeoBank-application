package com.neobank.clearing;
import java.util.List; import java.util.UUID;
public interface CentralCounterpartyNovationService {
    List<CentralCounterpartyNovationDto> getByUser(UUID userId);
    CentralCounterpartyNovationDto create(CentralCounterpartyNovationDto dto);
    CentralCounterpartyNovationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CentralCounterpartyNovationDto> listAll();
}
