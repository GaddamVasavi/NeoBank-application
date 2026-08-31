package com.neobank.transfer;
import java.util.List; import java.util.UUID;
public interface BatchTransferJobService {
    List<BatchTransferJobDto> getByAccount(UUID accountId);
    BatchTransferJobDto create(BatchTransferJobDto dto);
    BatchTransferJobDto getByTrackingNumber(String trackingNumber);
    void process(UUID id);
}
