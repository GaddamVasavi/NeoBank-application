package com.neobank.fraud;
import java.util.List; import java.util.UUID;
public interface AmlRuleConfigurationService {
    List<AmlRuleConfigurationDto> getByUser(UUID userId);
    AmlRuleConfigurationDto create(AmlRuleConfigurationDto dto);
    AmlRuleConfigurationDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<AmlRuleConfigurationDto> listAll();
}
