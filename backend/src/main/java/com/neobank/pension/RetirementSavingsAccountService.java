package com.neobank.pension;
import java.util.List; import java.util.UUID;
public interface RetirementSavingsAccountService {
    List<RetirementSavingsAccountDto> getByUser(UUID userId);
    RetirementSavingsAccountDto create(RetirementSavingsAccountDto dto);
    RetirementSavingsAccountDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<RetirementSavingsAccountDto> listAll();
}
