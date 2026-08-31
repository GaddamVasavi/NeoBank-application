package com.neobank.account;
import java.util.List; import java.util.UUID;
public interface AccountFeeScheduleService {
    List<AccountFeeScheduleDto> getByAccount(UUID accountId);
    AccountFeeScheduleDto create(AccountFeeScheduleDto dto);
    AccountFeeScheduleDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
