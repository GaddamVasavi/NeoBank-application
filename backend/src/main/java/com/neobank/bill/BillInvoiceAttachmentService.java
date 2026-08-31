package com.neobank.bill;
import java.util.List; import java.util.UUID;
public interface BillInvoiceAttachmentService {
    List<BillInvoiceAttachmentDto> getByUser(UUID userId);
    BillInvoiceAttachmentDto create(BillInvoiceAttachmentDto dto);
    BillInvoiceAttachmentDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<BillInvoiceAttachmentDto> listAll();
}
