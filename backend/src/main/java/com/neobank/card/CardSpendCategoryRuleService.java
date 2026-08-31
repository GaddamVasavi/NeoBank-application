package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface CardSpendCategoryRuleService {
    List<CardSpendCategoryRuleDto> getByUser(UUID userId);
    CardSpendCategoryRuleDto create(CardSpendCategoryRuleDto dto);
    CardSpendCategoryRuleDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
