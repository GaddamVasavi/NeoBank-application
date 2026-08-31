package com.neobank.marketing;
import java.util.List; import java.util.UUID;
public interface CashbackTierMultiplierRuleService {
    List<CashbackTierMultiplierRuleDto> getByUser(UUID userId);
    CashbackTierMultiplierRuleDto create(CashbackTierMultiplierRuleDto dto);
    CashbackTierMultiplierRuleDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CashbackTierMultiplierRuleDto> listAll();
}
