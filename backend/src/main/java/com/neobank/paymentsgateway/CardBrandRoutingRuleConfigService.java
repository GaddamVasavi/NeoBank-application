package com.neobank.paymentsgateway;
import java.util.List; import java.util.UUID;
public interface CardBrandRoutingRuleConfigService {
    List<CardBrandRoutingRuleConfigDto> getByUser(UUID userId);
    CardBrandRoutingRuleConfigDto create(CardBrandRoutingRuleConfigDto dto);
    CardBrandRoutingRuleConfigDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<CardBrandRoutingRuleConfigDto> listAll();
}
