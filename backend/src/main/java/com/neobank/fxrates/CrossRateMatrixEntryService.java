package com.neobank.fxrates;
import java.util.List; import java.util.UUID;
public interface CrossRateMatrixEntryService {
    List<CrossRateMatrixEntryDto> getByUser(UUID userId);
    CrossRateMatrixEntryDto create(CrossRateMatrixEntryDto dto);
    CrossRateMatrixEntryDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CrossRateMatrixEntryDto> listAll();
}
