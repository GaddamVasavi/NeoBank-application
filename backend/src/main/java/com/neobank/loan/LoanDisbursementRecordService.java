package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface LoanDisbursementRecordService {
    List<LoanDisbursementRecordDto> getByUser(UUID userId);
    LoanDisbursementRecordDto create(LoanDisbursementRecordDto dto);
    LoanDisbursementRecordDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<LoanDisbursementRecordDto> listAll();
}
