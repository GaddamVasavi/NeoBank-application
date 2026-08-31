package com.neobank.treasuryoperations;
import java.util.List; import java.util.UUID;
public interface LiquidityCoverageStressRunService {
    List<LiquidityCoverageStressRunDto> getByUser(UUID userId);
    LiquidityCoverageStressRunDto create(LiquidityCoverageStressRunDto dto);
    LiquidityCoverageStressRunDto getByIdentifier(String id);
    void updateStatus(UUID id, String status);
    List<LiquidityCoverageStressRunDto> listAll();
}
