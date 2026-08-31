package com.neobank.fintech;
import java.util.List; import java.util.UUID;
public interface InstantSettlementBridgeNodeService {
    List<InstantSettlementBridgeNodeDto> getByUser(UUID userId);
    InstantSettlementBridgeNodeDto create(InstantSettlementBridgeNodeDto dto);
    InstantSettlementBridgeNodeDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<InstantSettlementBridgeNodeDto> listAll();
}
