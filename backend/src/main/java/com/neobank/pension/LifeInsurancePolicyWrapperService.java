package com.neobank.pension;
import java.util.List; import java.util.UUID;
public interface LifeInsurancePolicyWrapperService {
    List<LifeInsurancePolicyWrapperDto> getByUser(UUID userId);
    LifeInsurancePolicyWrapperDto create(LifeInsurancePolicyWrapperDto dto);
    LifeInsurancePolicyWrapperDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<LifeInsurancePolicyWrapperDto> listAll();
}
