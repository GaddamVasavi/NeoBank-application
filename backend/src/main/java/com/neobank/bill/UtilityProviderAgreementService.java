package com.neobank.bill;
import java.util.List; import java.util.UUID;
public interface UtilityProviderAgreementService {
    List<UtilityProviderAgreementDto> getByUser(UUID userId);
    UtilityProviderAgreementDto create(UtilityProviderAgreementDto dto);
    UtilityProviderAgreementDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<UtilityProviderAgreementDto> listAll();
}
