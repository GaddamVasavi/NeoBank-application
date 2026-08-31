package com.neobank.corporate;
import java.util.List; import java.util.UUID;
public interface MultiCurrencyNotionalPoolService {
    List<MultiCurrencyNotionalPoolDto> getByUser(UUID userId);
    MultiCurrencyNotionalPoolDto create(MultiCurrencyNotionalPoolDto dto);
    MultiCurrencyNotionalPoolDto getByCode(String code);
    void updateState(UUID id, String state);
    List<MultiCurrencyNotionalPoolDto> listAll();
}
