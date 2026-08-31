package com.neobank.interbankclearing;
import java.util.List; import java.util.UUID;
public interface ClearingHouseDefaultFundService {
    List<ClearingHouseDefaultFundDto> getByUser(UUID userId);
    ClearingHouseDefaultFundDto create(ClearingHouseDefaultFundDto dto);
    ClearingHouseDefaultFundDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<ClearingHouseDefaultFundDto> listAll();
}
