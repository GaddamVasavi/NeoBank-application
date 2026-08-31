package com.neobank.treasury;
import java.util.List; import java.util.UUID;
public interface FxSpotOrderTradeService {
    List<FxSpotOrderTradeDto> getByUser(UUID userId);
    FxSpotOrderTradeDto create(FxSpotOrderTradeDto dto);
    FxSpotOrderTradeDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<FxSpotOrderTradeDto> listAll();
}
