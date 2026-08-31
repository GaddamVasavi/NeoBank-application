package com.neobank.governance;
import java.util.List; import java.util.UUID;
public interface InsiderTradingRegistryService {
    List<InsiderTradingRegistryDto> getByUser(UUID userId);
    InsiderTradingRegistryDto create(InsiderTradingRegistryDto dto);
    InsiderTradingRegistryDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<InsiderTradingRegistryDto> listAll();
}
