package com.neobank.risk;
import java.util.List; import java.util.UUID;
public interface ModelRiskValidationAuditService {
    List<ModelRiskValidationAuditDto> getByUser(UUID userId);
    ModelRiskValidationAuditDto create(ModelRiskValidationAuditDto dto);
    ModelRiskValidationAuditDto getByCode(String code);
    void updateState(UUID id, String state);
    List<ModelRiskValidationAuditDto> listAll();
}
