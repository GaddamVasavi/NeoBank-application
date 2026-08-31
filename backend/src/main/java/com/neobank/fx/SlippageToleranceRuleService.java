package com.neobank.fx;
import java.util.List; import java.util.UUID;
public interface SlippageToleranceRuleService {
    List<SlippageToleranceRuleDto> getByUser(UUID userId);
    SlippageToleranceRuleDto create(SlippageToleranceRuleDto dto);
    SlippageToleranceRuleDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<SlippageToleranceRuleDto> listAll();
}
