package com.neobank.settlementgateway;
import java.util.List; import java.util.UUID;
public interface CentralSecuritiesDepositoryLinkService {
    List<CentralSecuritiesDepositoryLinkDto> getByUser(UUID userId);
    CentralSecuritiesDepositoryLinkDto create(CentralSecuritiesDepositoryLinkDto dto);
    CentralSecuritiesDepositoryLinkDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<CentralSecuritiesDepositoryLinkDto> listAll();
}
