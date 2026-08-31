package com.neobank.paymentsgateway;
import java.util.List; import java.util.UUID;
public interface SurchargeFeeRuleConfigService {
    List<SurchargeFeeRuleConfigDto> getByUser(UUID userId);
    SurchargeFeeRuleConfigDto create(SurchargeFeeRuleConfigDto dto);
    SurchargeFeeRuleConfigDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<SurchargeFeeRuleConfigDto> listAll();
}
