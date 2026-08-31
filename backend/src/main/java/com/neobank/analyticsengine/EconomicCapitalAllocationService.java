package com.neobank.analyticsengine;
import java.util.List; import java.util.UUID;
public interface EconomicCapitalAllocationService {
    List<EconomicCapitalAllocationDto> getByUser(UUID userId);
    EconomicCapitalAllocationDto create(EconomicCapitalAllocationDto dto);
    EconomicCapitalAllocationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<EconomicCapitalAllocationDto> listAll();
}
