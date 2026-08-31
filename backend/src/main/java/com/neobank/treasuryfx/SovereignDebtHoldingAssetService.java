package com.neobank.treasuryfx;
import java.util.List; import java.util.UUID;
public interface SovereignDebtHoldingAssetService {
    List<SovereignDebtHoldingAssetDto> getByUser(UUID userId);
    SovereignDebtHoldingAssetDto create(SovereignDebtHoldingAssetDto dto);
    SovereignDebtHoldingAssetDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<SovereignDebtHoldingAssetDto> listAll();
}
