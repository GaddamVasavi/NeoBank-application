package com.neobank.fx;
import java.util.List; import java.util.UUID;
public interface MultiCurrencySettlementPoolService {
    List<MultiCurrencySettlementPoolDto> getByUser(UUID userId);
    MultiCurrencySettlementPoolDto create(MultiCurrencySettlementPoolDto dto);
    MultiCurrencySettlementPoolDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<MultiCurrencySettlementPoolDto> listAll();
}
