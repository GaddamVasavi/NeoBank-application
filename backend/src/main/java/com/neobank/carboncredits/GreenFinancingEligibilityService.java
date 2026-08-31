package com.neobank.carboncredits;
import java.util.List; import java.util.UUID;
public interface GreenFinancingEligibilityService {
    List<GreenFinancingEligibilityDto> getByUser(UUID userId);
    GreenFinancingEligibilityDto create(GreenFinancingEligibilityDto dto);
    GreenFinancingEligibilityDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<GreenFinancingEligibilityDto> listAll();
}
