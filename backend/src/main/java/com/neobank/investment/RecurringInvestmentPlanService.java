package com.neobank.investment;
import java.util.List; import java.util.UUID;
public interface RecurringInvestmentPlanService {
    List<RecurringInvestmentPlanDto> getByUser(UUID userId);
    RecurringInvestmentPlanDto create(RecurringInvestmentPlanDto dto);
    RecurringInvestmentPlanDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<RecurringInvestmentPlanDto> listAll();
}
