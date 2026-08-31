package com.neobank.settlement;
import java.util.List; import java.util.UUID;
public interface NostroVostroReconciliationService {
    List<NostroVostroReconciliationDto> getByUser(UUID userId);
    NostroVostroReconciliationDto create(NostroVostroReconciliationDto dto);
    NostroVostroReconciliationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<NostroVostroReconciliationDto> listAll();
}
