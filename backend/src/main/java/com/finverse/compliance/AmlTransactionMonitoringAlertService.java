package com.finverse.compliance;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for AmlTransactionMonitoringAlert
 */
public interface AmlTransactionMonitoringAlertService {

    List<AmlTransactionMonitoringAlertDto> getByTenant(UUID tenantId);

    List<AmlTransactionMonitoringAlertDto> getByUser(UUID userId);

    AmlTransactionMonitoringAlertDto create(AmlTransactionMonitoringAlertDto dto);

    AmlTransactionMonitoringAlertDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<AmlTransactionMonitoringAlertDto> listAll();
}
