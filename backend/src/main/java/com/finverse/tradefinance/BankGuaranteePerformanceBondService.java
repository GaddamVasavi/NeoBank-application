package com.finverse.tradefinance;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for BankGuaranteePerformanceBond
 */
public interface BankGuaranteePerformanceBondService {

    List<BankGuaranteePerformanceBondDto> getByTenant(UUID tenantId);

    List<BankGuaranteePerformanceBondDto> getByUser(UUID userId);

    BankGuaranteePerformanceBondDto create(BankGuaranteePerformanceBondDto dto);

    BankGuaranteePerformanceBondDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<BankGuaranteePerformanceBondDto> listAll();
}
