package com.neobank.corepayments;
import java.util.List; import java.util.UUID;
public interface SwiftGpiPaymentTrackerRecordService {
    List<SwiftGpiPaymentTrackerRecordDto> getByUser(UUID userId);
    SwiftGpiPaymentTrackerRecordDto create(SwiftGpiPaymentTrackerRecordDto dto);
    SwiftGpiPaymentTrackerRecordDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SwiftGpiPaymentTrackerRecordDto> listAll();
}
