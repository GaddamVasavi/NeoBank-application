package com.neobank.marketing;
import java.util.List; import java.util.UUID;
public interface CashRewardDisbursementLogService {
    List<CashRewardDisbursementLogDto> getByUser(UUID userId);
    CashRewardDisbursementLogDto create(CashRewardDisbursementLogDto dto);
    CashRewardDisbursementLogDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CashRewardDisbursementLogDto> listAll();
}
