package com.neobank.settlement;
import java.util.List; import java.util.UUID;
public interface CentralSecuritiesDepositoryService {
    List<CentralSecuritiesDepositoryDto> getByUser(UUID userId);
    CentralSecuritiesDepositoryDto create(CentralSecuritiesDepositoryDto dto);
    CentralSecuritiesDepositoryDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CentralSecuritiesDepositoryDto> listAll();
}
