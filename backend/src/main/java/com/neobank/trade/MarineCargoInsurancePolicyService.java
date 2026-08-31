package com.neobank.trade;
import java.util.List; import java.util.UUID;
public interface MarineCargoInsurancePolicyService {
    List<MarineCargoInsurancePolicyDto> getByUser(UUID userId);
    MarineCargoInsurancePolicyDto create(MarineCargoInsurancePolicyDto dto);
    MarineCargoInsurancePolicyDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<MarineCargoInsurancePolicyDto> listAll();
}
