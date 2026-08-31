package com.neobank.trade;
import java.util.List; import java.util.UUID;
public interface ExportCreditAgencyGuaranteeService {
    List<ExportCreditAgencyGuaranteeDto> getByUser(UUID userId);
    ExportCreditAgencyGuaranteeDto create(ExportCreditAgencyGuaranteeDto dto);
    ExportCreditAgencyGuaranteeDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ExportCreditAgencyGuaranteeDto> listAll();
}
