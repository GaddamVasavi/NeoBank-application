package com.neobank.clearing;
import java.util.List; import java.util.UUID;
public interface VariationMarginSettlementFileService {
    List<VariationMarginSettlementFileDto> getByUser(UUID userId);
    VariationMarginSettlementFileDto create(VariationMarginSettlementFileDto dto);
    VariationMarginSettlementFileDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<VariationMarginSettlementFileDto> listAll();
}
