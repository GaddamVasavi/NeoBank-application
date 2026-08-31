package com.neobank.carboncredits;
import java.util.List; import java.util.UUID;
public interface EmissionsReductionProjectService {
    List<EmissionsReductionProjectDto> getByUser(UUID userId);
    EmissionsReductionProjectDto create(EmissionsReductionProjectDto dto);
    EmissionsReductionProjectDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<EmissionsReductionProjectDto> listAll();
}
