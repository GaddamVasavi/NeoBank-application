package com.neobank.treasuryoperations;
import java.util.List; import java.util.UUID;
public interface TripartyCollateralMarginService {
    List<TripartyCollateralMarginDto> getByUser(UUID userId);
    TripartyCollateralMarginDto create(TripartyCollateralMarginDto dto);
    TripartyCollateralMarginDto getByIdentifier(String id);
    void updateStatus(UUID id, String status);
    List<TripartyCollateralMarginDto> listAll();
}
