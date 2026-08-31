package com.neobank.fxrates;
import java.util.List; import java.util.UUID;
public interface CurrencyBasketAllocationService {
    List<CurrencyBasketAllocationDto> getByUser(UUID userId);
    CurrencyBasketAllocationDto create(CurrencyBasketAllocationDto dto);
    CurrencyBasketAllocationDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CurrencyBasketAllocationDto> listAll();
}
