package com.neobank.pension;
import java.util.List; import java.util.UUID;
public interface TaxDeferredGrowthScheduleService {
    List<TaxDeferredGrowthScheduleDto> getByUser(UUID userId);
    TaxDeferredGrowthScheduleDto create(TaxDeferredGrowthScheduleDto dto);
    TaxDeferredGrowthScheduleDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<TaxDeferredGrowthScheduleDto> listAll();
}
