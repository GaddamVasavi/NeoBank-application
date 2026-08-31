package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface KycRiskCategorizationService {
    List<KycRiskCategorizationDto> getByUser(UUID userId);
    KycRiskCategorizationDto create(KycRiskCategorizationDto dto);
    KycRiskCategorizationDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<KycRiskCategorizationDto> listAll();
}
