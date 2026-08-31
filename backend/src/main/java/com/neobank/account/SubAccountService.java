package com.neobank.account;
import java.util.List; import java.util.UUID;
public interface SubAccountService {
    List<SubAccountDto> getByAccount(UUID accountId);
    SubAccountDto create(SubAccountDto dto);
    SubAccountDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
