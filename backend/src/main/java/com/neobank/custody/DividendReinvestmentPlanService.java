package com.neobank.custody;
import java.util.List; import java.util.UUID;
public interface DividendReinvestmentPlanService {
    List<DividendReinvestmentPlanDto> getByUser(UUID userId);
    DividendReinvestmentPlanDto create(DividendReinvestmentPlanDto dto);
    DividendReinvestmentPlanDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DividendReinvestmentPlanDto> listAll();
}
