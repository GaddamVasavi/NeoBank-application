package com.neobank.investment;
import java.util.List; import java.util.UUID;
public interface TaxLossHarvestingRecordService {
    List<TaxLossHarvestingRecordDto> getByUser(UUID userId);
    TaxLossHarvestingRecordDto create(TaxLossHarvestingRecordDto dto);
    TaxLossHarvestingRecordDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<TaxLossHarvestingRecordDto> listAll();
}
