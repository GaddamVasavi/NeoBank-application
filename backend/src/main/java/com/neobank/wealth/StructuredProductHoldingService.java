package com.neobank.wealth;
import java.util.List; import java.util.UUID;
public interface StructuredProductHoldingService {
    List<StructuredProductHoldingDto> getByUser(UUID userId);
    StructuredProductHoldingDto create(StructuredProductHoldingDto dto);
    StructuredProductHoldingDto getByCode(String code);
    void updateState(UUID id, String state);
    List<StructuredProductHoldingDto> listAll();
}
