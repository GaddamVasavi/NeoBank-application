package com.neobank.openbanking;
import java.util.List; import java.util.UUID;
public interface OpenBankingApiTrafficLogService {
    List<OpenBankingApiTrafficLogDto> getByUser(UUID userId);
    OpenBankingApiTrafficLogDto create(OpenBankingApiTrafficLogDto dto);
    OpenBankingApiTrafficLogDto getByCode(String code);
    void updateState(UUID id, String state);
    List<OpenBankingApiTrafficLogDto> listAll();
}
