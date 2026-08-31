package com.neobank.treasury;
import java.util.List; import java.util.UUID;
public interface IntercompanyLoanFacilityService {
    List<IntercompanyLoanFacilityDto> getByUser(UUID userId);
    IntercompanyLoanFacilityDto create(IntercompanyLoanFacilityDto dto);
    IntercompanyLoanFacilityDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<IntercompanyLoanFacilityDto> listAll();
}
