package com.neobank.custody;
import java.util.List; import java.util.UUID;
public interface TripartyCollateralDealService {
    List<TripartyCollateralDealDto> getByUser(UUID userId);
    TripartyCollateralDealDto create(TripartyCollateralDealDto dto);
    TripartyCollateralDealDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<TripartyCollateralDealDto> listAll();
}
