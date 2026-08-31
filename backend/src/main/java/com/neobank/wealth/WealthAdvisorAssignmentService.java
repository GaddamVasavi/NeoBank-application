package com.neobank.wealth;
import java.util.List; import java.util.UUID;
public interface WealthAdvisorAssignmentService {
    List<WealthAdvisorAssignmentDto> getByUser(UUID userId);
    WealthAdvisorAssignmentDto create(WealthAdvisorAssignmentDto dto);
    WealthAdvisorAssignmentDto getByCode(String code);
    void updateState(UUID id, String state);
    List<WealthAdvisorAssignmentDto> listAll();
}
