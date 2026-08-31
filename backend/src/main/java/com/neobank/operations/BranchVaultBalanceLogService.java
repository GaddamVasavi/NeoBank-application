package com.neobank.operations;
import java.util.List; import java.util.UUID;
public interface BranchVaultBalanceLogService {
    List<BranchVaultBalanceLogDto> getByUser(UUID userId);
    BranchVaultBalanceLogDto create(BranchVaultBalanceLogDto dto);
    BranchVaultBalanceLogDto getByCode(String code);
    void updateState(UUID id, String state);
    List<BranchVaultBalanceLogDto> listAll();
}
