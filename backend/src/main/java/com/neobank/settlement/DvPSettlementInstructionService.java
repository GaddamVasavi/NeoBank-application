package com.neobank.settlement;
import java.util.List; import java.util.UUID;
public interface DvPSettlementInstructionService {
    List<DvPSettlementInstructionDto> getByUser(UUID userId);
    DvPSettlementInstructionDto create(DvPSettlementInstructionDto dto);
    DvPSettlementInstructionDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DvPSettlementInstructionDto> listAll();
}
