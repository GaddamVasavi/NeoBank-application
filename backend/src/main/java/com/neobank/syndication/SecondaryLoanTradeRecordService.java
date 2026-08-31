package com.neobank.syndication;
import java.util.List; import java.util.UUID;
public interface SecondaryLoanTradeRecordService {
    List<SecondaryLoanTradeRecordDto> getByUser(UUID userId);
    SecondaryLoanTradeRecordDto create(SecondaryLoanTradeRecordDto dto);
    SecondaryLoanTradeRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<SecondaryLoanTradeRecordDto> listAll();
}
