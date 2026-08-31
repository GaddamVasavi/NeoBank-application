package com.neobank.account;
import java.util.List; import java.util.UUID;
public interface EscrowAccountService {
    List<EscrowAccountDto> getByAccount(UUID accountId);
    EscrowAccountDto create(EscrowAccountDto dto);
    EscrowAccountDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
