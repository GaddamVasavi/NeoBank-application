package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface CardFraudAlertRuleService {
    List<CardFraudAlertRuleDto> getByUser(UUID userId);
    CardFraudAlertRuleDto create(CardFraudAlertRuleDto dto);
    CardFraudAlertRuleDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CardFraudAlertRuleDto> listAll();
}
