package com.neobank.securities;
import java.util.List; import java.util.UUID;
public interface MutualFundOrderBookRecordService {
    List<MutualFundOrderBookRecordDto> getByUser(UUID userId);
    MutualFundOrderBookRecordDto create(MutualFundOrderBookRecordDto dto);
    MutualFundOrderBookRecordDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<MutualFundOrderBookRecordDto> listAll();
}
