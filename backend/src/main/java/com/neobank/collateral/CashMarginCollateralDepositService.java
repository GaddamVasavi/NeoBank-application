package com.neobank.collateral;
import java.util.List; import java.util.UUID;
public interface CashMarginCollateralDepositService {
    List<CashMarginCollateralDepositDto> getByUser(UUID userId);
    CashMarginCollateralDepositDto create(CashMarginCollateralDepositDto dto);
    CashMarginCollateralDepositDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CashMarginCollateralDepositDto> listAll();
}
