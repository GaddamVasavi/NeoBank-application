package com.neobank.settlementgateway;
import java.util.List; import java.util.UUID;
public interface ClearingHouseMarginPoolService {
    List<ClearingHouseMarginPoolDto> getByUser(UUID userId);
    ClearingHouseMarginPoolDto create(ClearingHouseMarginPoolDto dto);
    ClearingHouseMarginPoolDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<ClearingHouseMarginPoolDto> listAll();
}
