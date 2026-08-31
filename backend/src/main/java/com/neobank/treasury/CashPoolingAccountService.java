package com.neobank.treasury;
import java.util.List; import java.util.UUID;
public interface CashPoolingAccountService {
    List<CashPoolingAccountDto> getByUser(UUID userId);
    CashPoolingAccountDto create(CashPoolingAccountDto dto);
    CashPoolingAccountDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<CashPoolingAccountDto> listAll();
}
