package com.neobank.analytics;
import java.util.List; import java.util.UUID;
public interface FeeIncomeAggregateService {
    List<FeeIncomeAggregateDto> getByUser(UUID userId);
    FeeIncomeAggregateDto create(FeeIncomeAggregateDto dto);
    FeeIncomeAggregateDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<FeeIncomeAggregateDto> listAll();
}
