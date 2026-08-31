package com.neobank.factoring;
import java.util.List; import java.util.UUID;
public interface InvoiceDisputeRetentionService {
    List<InvoiceDisputeRetentionDto> getByUser(UUID userId);
    InvoiceDisputeRetentionDto create(InvoiceDisputeRetentionDto dto);
    InvoiceDisputeRetentionDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<InvoiceDisputeRetentionDto> listAll();
}
