package com.neobank.settlement;
import java.util.List; import java.util.UUID;
public interface RealTimeGrossSettlementService {
    List<RealTimeGrossSettlementDto> getByUser(UUID userId);
    RealTimeGrossSettlementDto create(RealTimeGrossSettlementDto dto);
    RealTimeGrossSettlementDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<RealTimeGrossSettlementDto> listAll();
}
