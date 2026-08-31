package com.neobank.commercial;
import java.util.List; import java.util.UUID;
public interface CorporatePayrollBatchService {
    List<CorporatePayrollBatchDto> getByUser(UUID userId);
    CorporatePayrollBatchDto create(CorporatePayrollBatchDto dto);
    CorporatePayrollBatchDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<CorporatePayrollBatchDto> listAll();
}
