package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface KycRenewalScheduleService {
    List<KycRenewalScheduleDto> getByUser(UUID userId);
    KycRenewalScheduleDto create(KycRenewalScheduleDto dto);
    KycRenewalScheduleDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<KycRenewalScheduleDto> listAll();
}
