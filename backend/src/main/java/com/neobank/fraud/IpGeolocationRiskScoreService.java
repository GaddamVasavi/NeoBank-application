package com.neobank.fraud;
import java.util.List; import java.util.UUID;
public interface IpGeolocationRiskScoreService {
    List<IpGeolocationRiskScoreDto> getByUser(UUID userId);
    IpGeolocationRiskScoreDto create(IpGeolocationRiskScoreDto dto);
    IpGeolocationRiskScoreDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<IpGeolocationRiskScoreDto> listAll();
}
