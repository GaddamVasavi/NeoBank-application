package com.neobank.infrastructure;
import java.util.List; import java.util.UUID;
public interface CoreBankingHeartbeatPulseService {
    List<CoreBankingHeartbeatPulseDto> getByUser(UUID userId);
    CoreBankingHeartbeatPulseDto create(CoreBankingHeartbeatPulseDto dto);
    CoreBankingHeartbeatPulseDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CoreBankingHeartbeatPulseDto> listAll();
}
