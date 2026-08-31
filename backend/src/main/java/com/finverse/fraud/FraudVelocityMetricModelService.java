package com.finverse.fraud;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for FraudVelocityMetricModel
 */
public interface FraudVelocityMetricModelService {

    List<FraudVelocityMetricModelDto> getByTenant(UUID tenantId);

    List<FraudVelocityMetricModelDto> getByUser(UUID userId);

    FraudVelocityMetricModelDto create(FraudVelocityMetricModelDto dto);

    FraudVelocityMetricModelDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<FraudVelocityMetricModelDto> listAll();
}
