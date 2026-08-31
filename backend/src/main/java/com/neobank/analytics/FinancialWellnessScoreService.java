package com.neobank.analytics;
import java.util.List; import java.util.UUID;
public interface FinancialWellnessScoreService {
    List<FinancialWellnessScoreDto> getByUser(UUID userId);
    FinancialWellnessScoreDto create(FinancialWellnessScoreDto dto);
    FinancialWellnessScoreDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<FinancialWellnessScoreDto> listAll();
}
