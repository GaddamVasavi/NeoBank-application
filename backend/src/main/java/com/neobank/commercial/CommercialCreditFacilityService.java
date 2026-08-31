package com.neobank.commercial;
import java.util.List; import java.util.UUID;
public interface CommercialCreditFacilityService {
    List<CommercialCreditFacilityDto> getByUser(UUID userId);
    CommercialCreditFacilityDto create(CommercialCreditFacilityDto dto);
    CommercialCreditFacilityDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<CommercialCreditFacilityDto> listAll();
}
