package com.neobank.compliance;
import java.util.List; import java.util.UUID;
public interface DataRetentionPolicyRuleService {
    List<DataRetentionPolicyRuleDto> getByUser(UUID userId);
    DataRetentionPolicyRuleDto create(DataRetentionPolicyRuleDto dto);
    DataRetentionPolicyRuleDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<DataRetentionPolicyRuleDto> listAll();
}
