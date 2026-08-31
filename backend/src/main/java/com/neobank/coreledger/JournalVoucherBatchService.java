package com.neobank.coreledger;
import java.util.List; import java.util.UUID;
public interface JournalVoucherBatchService {
    List<JournalVoucherBatchDto> getByUser(UUID userId);
    JournalVoucherBatchDto create(JournalVoucherBatchDto dto);
    JournalVoucherBatchDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<JournalVoucherBatchDto> listAll();
}
