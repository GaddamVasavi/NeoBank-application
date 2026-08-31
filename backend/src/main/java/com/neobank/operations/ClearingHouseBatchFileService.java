package com.neobank.operations;
import java.util.List; import java.util.UUID;
public interface ClearingHouseBatchFileService {
    List<ClearingHouseBatchFileDto> getByUser(UUID userId);
    ClearingHouseBatchFileDto create(ClearingHouseBatchFileDto dto);
    ClearingHouseBatchFileDto getByCode(String code);
    void updateState(UUID id, String state);
    List<ClearingHouseBatchFileDto> listAll();
}
