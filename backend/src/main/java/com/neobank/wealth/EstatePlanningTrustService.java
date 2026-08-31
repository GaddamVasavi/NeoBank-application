package com.neobank.wealth;
import java.util.List; import java.util.UUID;
public interface EstatePlanningTrustService {
    List<EstatePlanningTrustDto> getByUser(UUID userId);
    EstatePlanningTrustDto create(EstatePlanningTrustDto dto);
    EstatePlanningTrustDto getByCode(String code);
    void updateState(UUID id, String state);
    List<EstatePlanningTrustDto> listAll();
}
