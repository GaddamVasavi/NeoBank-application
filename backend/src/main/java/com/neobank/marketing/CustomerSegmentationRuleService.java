package com.neobank.marketing;
import java.util.List; import java.util.UUID;
public interface CustomerSegmentationRuleService {
    List<CustomerSegmentationRuleDto> getByUser(UUID userId);
    CustomerSegmentationRuleDto create(CustomerSegmentationRuleDto dto);
    CustomerSegmentationRuleDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CustomerSegmentationRuleDto> listAll();
}
