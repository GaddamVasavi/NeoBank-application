package com.neobank.bill;
import java.util.List; import java.util.UUID;
public interface BillPaymentReceiptService {
    List<BillPaymentReceiptDto> getByUser(UUID userId);
    BillPaymentReceiptDto create(BillPaymentReceiptDto dto);
    BillPaymentReceiptDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<BillPaymentReceiptDto> listAll();
}
