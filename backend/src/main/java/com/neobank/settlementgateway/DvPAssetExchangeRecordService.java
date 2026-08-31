package com.neobank.settlementgateway;
import java.util.List; import java.util.UUID;
public interface DvPAssetExchangeRecordService {
    List<DvPAssetExchangeRecordDto> getByUser(UUID userId);
    DvPAssetExchangeRecordDto create(DvPAssetExchangeRecordDto dto);
    DvPAssetExchangeRecordDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<DvPAssetExchangeRecordDto> listAll();
}
