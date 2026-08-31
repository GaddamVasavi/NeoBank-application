package com.neobank.loan;
import java.util.List; import java.util.UUID;
public interface LoanCollateralValuationService {
    List<LoanCollateralValuationDto> getByUser(UUID userId);
    LoanCollateralValuationDto create(LoanCollateralValuationDto dto);
    LoanCollateralValuationDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<LoanCollateralValuationDto> listAll();
}
