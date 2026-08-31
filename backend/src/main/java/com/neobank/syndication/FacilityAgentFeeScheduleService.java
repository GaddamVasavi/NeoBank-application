package com.neobank.syndication;
import java.util.List; import java.util.UUID;
public interface FacilityAgentFeeScheduleService {
    List<FacilityAgentFeeScheduleDto> getByUser(UUID userId);
    FacilityAgentFeeScheduleDto create(FacilityAgentFeeScheduleDto dto);
    FacilityAgentFeeScheduleDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<FacilityAgentFeeScheduleDto> listAll();
}
