package com.neobank.analytics;
import java.util.List; import java.util.UUID;
public interface BudgetAdherenceScoreService {
    List<BudgetAdherenceScoreDto> getByUser(UUID userId);
    BudgetAdherenceScoreDto create(BudgetAdherenceScoreDto dto);
    BudgetAdherenceScoreDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<BudgetAdherenceScoreDto> listAll();
}
