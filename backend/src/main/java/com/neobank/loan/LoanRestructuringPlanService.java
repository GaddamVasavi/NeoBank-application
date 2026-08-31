package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface LoanRestructuringPlanService {
    List<LoanRestructuringPlanDto> getByUser(UUID userId);
    LoanRestructuringPlanDto create(LoanRestructuringPlanDto dto);
    LoanRestructuringPlanDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<LoanRestructuringPlanDto> listAll();
}
