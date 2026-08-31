package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface LoanAmortizationEntryService {
    List<LoanAmortizationEntryDto> getByUser(UUID userId);
    LoanAmortizationEntryDto create(LoanAmortizationEntryDto dto);
    LoanAmortizationEntryDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<LoanAmortizationEntryDto> listAll();
}
