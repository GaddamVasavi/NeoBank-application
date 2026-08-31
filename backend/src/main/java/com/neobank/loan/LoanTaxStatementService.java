package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface LoanTaxStatementService {
    List<LoanTaxStatementDto> getByUser(UUID userId);
    LoanTaxStatementDto create(LoanTaxStatementDto dto);
    LoanTaxStatementDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<LoanTaxStatementDto> listAll();
}
