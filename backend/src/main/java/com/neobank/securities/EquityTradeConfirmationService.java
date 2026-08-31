package com.neobank.securities;
import java.util.List; import java.util.UUID;
public interface EquityTradeConfirmationService {
    List<EquityTradeConfirmationDto> getByUser(UUID userId);
    EquityTradeConfirmationDto create(EquityTradeConfirmationDto dto);
    EquityTradeConfirmationDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<EquityTradeConfirmationDto> listAll();
}
