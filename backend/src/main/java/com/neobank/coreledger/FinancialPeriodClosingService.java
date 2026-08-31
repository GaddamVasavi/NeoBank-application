package com.neobank.coreledger;
import java.util.List; import java.util.UUID;
public interface FinancialPeriodClosingService {
    List<FinancialPeriodClosingDto> getByUser(UUID userId);
    FinancialPeriodClosingDto create(FinancialPeriodClosingDto dto);
    FinancialPeriodClosingDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<FinancialPeriodClosingDto> listAll();
}
