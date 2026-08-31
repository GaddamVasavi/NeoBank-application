package com.neobank.reconciliation;
import java.util.List; import java.util.UUID;
public interface AutomatedBreakResolutionService {
    List<AutomatedBreakResolutionDto> getByUser(UUID userId);
    AutomatedBreakResolutionDto create(AutomatedBreakResolutionDto dto);
    AutomatedBreakResolutionDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<AutomatedBreakResolutionDto> listAll();
}
