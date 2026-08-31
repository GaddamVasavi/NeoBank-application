package com.neobank.admin;
import java.util.List; import java.util.UUID;
public interface CurrencyExchangeSpreadService {
    List<CurrencyExchangeSpreadDto> getByUser(UUID userId);
    CurrencyExchangeSpreadDto create(CurrencyExchangeSpreadDto dto);
    CurrencyExchangeSpreadDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CurrencyExchangeSpreadDto> listAll();
}
