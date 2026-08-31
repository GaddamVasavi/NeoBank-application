package com.neobank.pension;
import java.util.List; import java.util.UUID;
public interface BeneficiaryDesignationAuditService {
    List<BeneficiaryDesignationAuditDto> getByUser(UUID userId);
    BeneficiaryDesignationAuditDto create(BeneficiaryDesignationAuditDto dto);
    BeneficiaryDesignationAuditDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<BeneficiaryDesignationAuditDto> listAll();
}
