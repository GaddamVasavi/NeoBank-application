package com.neobank.corporate;
import java.util.List; import java.util.UUID;
public interface CorporateCashManagementService {
    List<CorporateCashManagementDto> getByUser(UUID userId);
    CorporateCashManagementDto create(CorporateCashManagementDto dto);
    CorporateCashManagementDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CorporateCashManagementDto> listAll();
}
