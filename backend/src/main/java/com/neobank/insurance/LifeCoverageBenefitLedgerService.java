package com.neobank.insurance;
import java.util.List; import java.util.UUID;
public interface LifeCoverageBenefitLedgerService {
    List<LifeCoverageBenefitLedgerDto> getByUser(UUID userId);
    LifeCoverageBenefitLedgerDto create(LifeCoverageBenefitLedgerDto dto);
    LifeCoverageBenefitLedgerDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<LifeCoverageBenefitLedgerDto> listAll();
}
