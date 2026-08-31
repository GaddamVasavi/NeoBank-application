package com.neobank.fraud;
import java.util.List; import java.util.UUID;
public interface AccountTakeoverSignalService {
    List<AccountTakeoverSignalDto> getByUser(UUID userId);
    AccountTakeoverSignalDto create(AccountTakeoverSignalDto dto);
    AccountTakeoverSignalDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<AccountTakeoverSignalDto> listAll();
}
