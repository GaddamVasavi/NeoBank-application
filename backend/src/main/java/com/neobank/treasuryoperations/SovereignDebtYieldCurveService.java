package com.neobank.treasuryoperations;
import java.util.List; import java.util.UUID;
public interface SovereignDebtYieldCurveService {
    List<SovereignDebtYieldCurveDto> getByUser(UUID userId);
    SovereignDebtYieldCurveDto create(SovereignDebtYieldCurveDto dto);
    SovereignDebtYieldCurveDto getByIdentifier(String id);
    void updateStatus(UUID id, String status);
    List<SovereignDebtYieldCurveDto> listAll();
}
