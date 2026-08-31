package com.neobank.openbanking;
import java.util.List; import java.util.UUID;
public interface AccountInformationRequestLogService {
    List<AccountInformationRequestLogDto> getByUser(UUID userId);
    AccountInformationRequestLogDto create(AccountInformationRequestLogDto dto);
    AccountInformationRequestLogDto getByCode(String code);
    void updateState(UUID id, String state);
    List<AccountInformationRequestLogDto> listAll();
}
