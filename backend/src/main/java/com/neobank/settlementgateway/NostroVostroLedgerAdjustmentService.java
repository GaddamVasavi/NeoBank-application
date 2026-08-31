package com.neobank.settlementgateway;
import java.util.List; import java.util.UUID;
public interface NostroVostroLedgerAdjustmentService {
    List<NostroVostroLedgerAdjustmentDto> getByUser(UUID userId);
    NostroVostroLedgerAdjustmentDto create(NostroVostroLedgerAdjustmentDto dto);
    NostroVostroLedgerAdjustmentDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<NostroVostroLedgerAdjustmentDto> listAll();
}
