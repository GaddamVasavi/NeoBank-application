package com.neobank.interbankclearing;
import java.util.List; import java.util.UUID;
public interface ChipsSettlementConfirmationService {
    List<ChipsSettlementConfirmationDto> getByUser(UUID userId);
    ChipsSettlementConfirmationDto create(ChipsSettlementConfirmationDto dto);
    ChipsSettlementConfirmationDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<ChipsSettlementConfirmationDto> listAll();
}
