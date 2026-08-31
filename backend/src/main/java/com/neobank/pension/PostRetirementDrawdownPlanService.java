package com.neobank.pension;
import java.util.List; import java.util.UUID;
public interface PostRetirementDrawdownPlanService {
    List<PostRetirementDrawdownPlanDto> getByUser(UUID userId);
    PostRetirementDrawdownPlanDto create(PostRetirementDrawdownPlanDto dto);
    PostRetirementDrawdownPlanDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<PostRetirementDrawdownPlanDto> listAll();
}
