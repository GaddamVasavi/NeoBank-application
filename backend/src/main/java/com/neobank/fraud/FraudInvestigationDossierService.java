package com.neobank.fraud;
import java.util.List; import java.util.UUID;
public interface FraudInvestigationDossierService {
    List<FraudInvestigationDossierDto> getByUser(UUID userId);
    FraudInvestigationDossierDto create(FraudInvestigationDossierDto dto);
    FraudInvestigationDossierDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<FraudInvestigationDossierDto> listAll();
}
