package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface LoanEarlyPayoffQuoteService {
    List<LoanEarlyPayoffQuoteDto> getByUser(UUID userId);
    LoanEarlyPayoffQuoteDto create(LoanEarlyPayoffQuoteDto dto);
    LoanEarlyPayoffQuoteDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<LoanEarlyPayoffQuoteDto> listAll();
}
