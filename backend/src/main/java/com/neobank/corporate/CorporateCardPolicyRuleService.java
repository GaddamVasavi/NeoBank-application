package com.neobank.corporate;
import java.util.List; import java.util.UUID;
public interface CorporateCardPolicyRuleService {
    List<CorporateCardPolicyRuleDto> getByUser(UUID userId);
    CorporateCardPolicyRuleDto create(CorporateCardPolicyRuleDto dto);
    CorporateCardPolicyRuleDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CorporateCardPolicyRuleDto> listAll();
}
