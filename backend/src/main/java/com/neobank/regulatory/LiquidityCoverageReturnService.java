package com.neobank.regulatory;
import java.util.List; import java.util.UUID;
public interface LiquidityCoverageReturnService {
    List<LiquidityCoverageReturnDto> getByUser(UUID userId);
    LiquidityCoverageReturnDto create(LiquidityCoverageReturnDto dto);
    LiquidityCoverageReturnDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<LiquidityCoverageReturnDto> listAll();
}
