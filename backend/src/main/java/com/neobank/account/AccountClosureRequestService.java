package com.neobank.account;
import java.util.List; import java.util.UUID;
public interface AccountClosureRequestService {
    List<AccountClosureRequestDto> getByAccount(UUID accountId);
    AccountClosureRequestDto create(AccountClosureRequestDto dto);
    AccountClosureRequestDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
