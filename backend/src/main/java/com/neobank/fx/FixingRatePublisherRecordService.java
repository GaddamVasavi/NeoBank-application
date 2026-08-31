package com.neobank.fx;
import java.util.List; import java.util.UUID;
public interface FixingRatePublisherRecordService {
    List<FixingRatePublisherRecordDto> getByUser(UUID userId);
    FixingRatePublisherRecordDto create(FixingRatePublisherRecordDto dto);
    FixingRatePublisherRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<FixingRatePublisherRecordDto> listAll();
}
