package com.neobank.trade;
import java.util.List; import java.util.UUID;
public interface ShippingConsignmentLedgerService {
    List<ShippingConsignmentLedgerDto> getByUser(UUID userId);
    ShippingConsignmentLedgerDto create(ShippingConsignmentLedgerDto dto);
    ShippingConsignmentLedgerDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ShippingConsignmentLedgerDto> listAll();
}
