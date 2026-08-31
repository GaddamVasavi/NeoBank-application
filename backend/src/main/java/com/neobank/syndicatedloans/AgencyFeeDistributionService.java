package com.neobank.syndicatedloans;
import java.util.List; import java.util.UUID;
public interface AgencyFeeDistributionService {
    List<AgencyFeeDistributionDto> getByUser(UUID userId);
    AgencyFeeDistributionDto create(AgencyFeeDistributionDto dto);
    AgencyFeeDistributionDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<AgencyFeeDistributionDto> listAll();
}
