package com.neobank.governance;
import java.util.List; import java.util.UUID;
public interface ExecutiveCompensationPlanService {
    List<ExecutiveCompensationPlanDto> getByUser(UUID userId);
    ExecutiveCompensationPlanDto create(ExecutiveCompensationPlanDto dto);
    ExecutiveCompensationPlanDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ExecutiveCompensationPlanDto> listAll();
}
