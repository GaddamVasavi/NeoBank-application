package com.neobank.insurance;
import java.util.List; import java.util.UUID;
public interface InsuranceRegulatoryFilingService {
    List<InsuranceRegulatoryFilingDto> getByUser(UUID userId);
    InsuranceRegulatoryFilingDto create(InsuranceRegulatoryFilingDto dto);
    InsuranceRegulatoryFilingDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<InsuranceRegulatoryFilingDto> listAll();
}
