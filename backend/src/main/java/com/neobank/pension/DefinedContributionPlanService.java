package com.neobank.pension;
import java.util.List; import java.util.UUID;
public interface DefinedContributionPlanService {
    List<DefinedContributionPlanDto> getByUser(UUID userId);
    DefinedContributionPlanDto create(DefinedContributionPlanDto dto);
    DefinedContributionPlanDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DefinedContributionPlanDto> listAll();
}
