package com.neobank.syndicatedloans;
import java.util.List; import java.util.UUID;
public interface SecondaryMarketTradeLogService {
    List<SecondaryMarketTradeLogDto> getByUser(UUID userId);
    SecondaryMarketTradeLogDto create(SecondaryMarketTradeLogDto dto);
    SecondaryMarketTradeLogDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<SecondaryMarketTradeLogDto> listAll();
}
