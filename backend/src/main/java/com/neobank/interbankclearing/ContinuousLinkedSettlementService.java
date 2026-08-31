package com.neobank.interbankclearing;
import java.util.List; import java.util.UUID;
public interface ContinuousLinkedSettlementService {
    List<ContinuousLinkedSettlementDto> getByUser(UUID userId);
    ContinuousLinkedSettlementDto create(ContinuousLinkedSettlementDto dto);
    ContinuousLinkedSettlementDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<ContinuousLinkedSettlementDto> listAll();
}
