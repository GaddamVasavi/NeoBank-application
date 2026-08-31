package com.neobank.openbanking;
import java.util.List; import java.util.UUID;
public interface ConfirmationOfFundsLogService {
    List<ConfirmationOfFundsLogDto> getByUser(UUID userId);
    ConfirmationOfFundsLogDto create(ConfirmationOfFundsLogDto dto);
    ConfirmationOfFundsLogDto getByCode(String code);
    void updateState(UUID id, String state);
    List<ConfirmationOfFundsLogDto> listAll();
}
