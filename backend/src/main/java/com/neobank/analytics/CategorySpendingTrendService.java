package com.neobank.analytics;
import java.util.List; import java.util.UUID;
public interface CategorySpendingTrendService {
    List<CategorySpendingTrendDto> getByUser(UUID userId);
    CategorySpendingTrendDto create(CategorySpendingTrendDto dto);
    CategorySpendingTrendDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CategorySpendingTrendDto> listAll();
}
