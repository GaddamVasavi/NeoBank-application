package com.neobank.trade;
import java.util.List; import java.util.UUID;
public interface BillOfExchangeAcceptanceService {
    List<BillOfExchangeAcceptanceDto> getByUser(UUID userId);
    BillOfExchangeAcceptanceDto create(BillOfExchangeAcceptanceDto dto);
    BillOfExchangeAcceptanceDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<BillOfExchangeAcceptanceDto> listAll();
}
