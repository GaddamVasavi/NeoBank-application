package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface CorporateBeneficialOwnerService {
    List<CorporateBeneficialOwnerDto> getByUser(UUID userId);
    CorporateBeneficialOwnerDto create(CorporateBeneficialOwnerDto dto);
    CorporateBeneficialOwnerDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CorporateBeneficialOwnerDto> listAll();
}
