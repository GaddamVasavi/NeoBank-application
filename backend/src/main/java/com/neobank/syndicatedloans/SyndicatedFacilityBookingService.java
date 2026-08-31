package com.neobank.syndicatedloans;
import java.util.List; import java.util.UUID;
public interface SyndicatedFacilityBookingService {
    List<SyndicatedFacilityBookingDto> getByUser(UUID userId);
    SyndicatedFacilityBookingDto create(SyndicatedFacilityBookingDto dto);
    SyndicatedFacilityBookingDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<SyndicatedFacilityBookingDto> listAll();
}
