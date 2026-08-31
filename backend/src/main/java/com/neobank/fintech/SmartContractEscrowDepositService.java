package com.neobank.fintech;
import java.util.List; import java.util.UUID;
public interface SmartContractEscrowDepositService {
    List<SmartContractEscrowDepositDto> getByUser(UUID userId);
    SmartContractEscrowDepositDto create(SmartContractEscrowDepositDto dto);
    SmartContractEscrowDepositDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<SmartContractEscrowDepositDto> listAll();
}
