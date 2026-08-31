package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface LoanRepaymentTransactionService {
    List<LoanRepaymentTransactionDto> getByUser(UUID userId);
    LoanRepaymentTransactionDto create(LoanRepaymentTransactionDto dto);
    LoanRepaymentTransactionDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<LoanRepaymentTransactionDto> listAll();
}
