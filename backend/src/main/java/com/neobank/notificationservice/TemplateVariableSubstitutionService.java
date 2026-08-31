package com.neobank.notificationservice;
import java.util.List; import java.util.UUID;
public interface TemplateVariableSubstitutionService {
    List<TemplateVariableSubstitutionDto> getByUser(UUID userId);
    TemplateVariableSubstitutionDto create(TemplateVariableSubstitutionDto dto);
    TemplateVariableSubstitutionDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<TemplateVariableSubstitutionDto> listAll();
}
