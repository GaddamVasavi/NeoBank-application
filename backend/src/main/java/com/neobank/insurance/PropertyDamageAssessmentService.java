package com.neobank.insurance;
import java.util.List; import java.util.UUID;
public interface PropertyDamageAssessmentService {
    List<PropertyDamageAssessmentDto> getByUser(UUID userId);
    PropertyDamageAssessmentDto create(PropertyDamageAssessmentDto dto);
    PropertyDamageAssessmentDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<PropertyDamageAssessmentDto> listAll();
}
