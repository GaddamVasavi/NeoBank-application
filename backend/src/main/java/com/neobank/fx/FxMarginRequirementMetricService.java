package com.neobank.fx;
import java.util.List; import java.util.UUID;
public interface FxMarginRequirementMetricService {
    List<FxMarginRequirementMetricDto> getByUser(UUID userId);
    FxMarginRequirementMetricDto create(FxMarginRequirementMetricDto dto);
    FxMarginRequirementMetricDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<FxMarginRequirementMetricDto> listAll();
}
