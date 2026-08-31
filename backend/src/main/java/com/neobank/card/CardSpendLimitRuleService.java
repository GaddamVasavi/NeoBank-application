package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface CardSpendLimitRuleService {
    List<CardSpendLimitRuleDto> getByUser(UUID userId);
    CardSpendLimitRuleDto create(CardSpendLimitRuleDto dto);
    CardSpendLimitRuleDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CardSpendLimitRuleDto> listAll();
}
