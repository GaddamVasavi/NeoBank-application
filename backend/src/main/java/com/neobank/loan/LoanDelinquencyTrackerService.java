package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface LoanDelinquencyTrackerService {
    List<LoanDelinquencyTrackerDto> getByUser(UUID userId);
    LoanDelinquencyTrackerDto create(LoanDelinquencyTrackerDto dto);
    LoanDelinquencyTrackerDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<LoanDelinquencyTrackerDto> listAll();
}
