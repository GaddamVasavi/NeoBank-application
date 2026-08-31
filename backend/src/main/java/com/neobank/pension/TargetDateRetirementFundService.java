package com.neobank.pension;
import java.util.List; import java.util.UUID;
public interface TargetDateRetirementFundService {
    List<TargetDateRetirementFundDto> getByUser(UUID userId);
    TargetDateRetirementFundDto create(TargetDateRetirementFundDto dto);
    TargetDateRetirementFundDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<TargetDateRetirementFundDto> listAll();
}
