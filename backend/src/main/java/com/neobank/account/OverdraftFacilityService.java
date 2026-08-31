package com.neobank.account;
import java.util.List; import java.util.UUID;
public interface OverdraftFacilityService {
    List<OverdraftFacilityDto> getByAccount(UUID accountId);
    OverdraftFacilityDto create(OverdraftFacilityDto dto);
    OverdraftFacilityDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
