package com.neobank.clearing;
import java.util.List; import java.util.UUID;
public interface IntradayMarginCallRecordService {
    List<IntradayMarginCallRecordDto> getByUser(UUID userId);
    IntradayMarginCallRecordDto create(IntradayMarginCallRecordDto dto);
    IntradayMarginCallRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<IntradayMarginCallRecordDto> listAll();
}
