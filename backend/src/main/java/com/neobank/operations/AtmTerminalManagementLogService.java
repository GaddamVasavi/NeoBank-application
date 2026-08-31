package com.neobank.operations;
import java.util.List; import java.util.UUID;
public interface AtmTerminalManagementLogService {
    List<AtmTerminalManagementLogDto> getByUser(UUID userId);
    AtmTerminalManagementLogDto create(AtmTerminalManagementLogDto dto);
    AtmTerminalManagementLogDto getByCode(String code);
    void updateState(UUID id, String state);
    List<AtmTerminalManagementLogDto> listAll();
}
