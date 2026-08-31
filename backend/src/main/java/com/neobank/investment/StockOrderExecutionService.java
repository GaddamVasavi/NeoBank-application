package com.neobank.investment;
import java.util.List; import java.util.UUID;
public interface StockOrderExecutionService {
    List<StockOrderExecutionDto> getByUser(UUID userId);
    StockOrderExecutionDto create(StockOrderExecutionDto dto);
    StockOrderExecutionDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<StockOrderExecutionDto> listAll();
}
