package com.neobank.transfer;
import java.util.List; import java.util.UUID;
public interface TransferDisputeRecordService {
    List<TransferDisputeRecordDto> getByAccount(UUID accountId);
    TransferDisputeRecordDto create(TransferDisputeRecordDto dto);
    TransferDisputeRecordDto getByTrackingNumber(String trackingNumber);
    void process(UUID id);
}
