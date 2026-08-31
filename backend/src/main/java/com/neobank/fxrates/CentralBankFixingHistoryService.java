package com.neobank.fxrates;
import java.util.List; import java.util.UUID;
public interface CentralBankFixingHistoryService {
    List<CentralBankFixingHistoryDto> getByUser(UUID userId);
    CentralBankFixingHistoryDto create(CentralBankFixingHistoryDto dto);
    CentralBankFixingHistoryDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CentralBankFixingHistoryDto> listAll();
}
