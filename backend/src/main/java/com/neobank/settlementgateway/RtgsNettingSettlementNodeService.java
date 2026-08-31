package com.neobank.settlementgateway;
import java.util.List; import java.util.UUID;
public interface RtgsNettingSettlementNodeService {
    List<RtgsNettingSettlementNodeDto> getByUser(UUID userId);
    RtgsNettingSettlementNodeDto create(RtgsNettingSettlementNodeDto dto);
    RtgsNettingSettlementNodeDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<RtgsNettingSettlementNodeDto> listAll();
}
