package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface LoanUnderwritingScorecardService {
    List<LoanUnderwritingScorecardDto> getByUser(UUID userId);
    LoanUnderwritingScorecardDto create(LoanUnderwritingScorecardDto dto);
    LoanUnderwritingScorecardDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
