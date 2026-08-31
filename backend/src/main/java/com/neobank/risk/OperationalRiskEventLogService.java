package com.neobank.risk;
import java.util.List; import java.util.UUID;
public interface OperationalRiskEventLogService {
    List<OperationalRiskEventLogDto> getByUser(UUID userId);
    OperationalRiskEventLogDto create(OperationalRiskEventLogDto dto);
    OperationalRiskEventLogDto getByCode(String code);
    void updateState(UUID id, String state);
    List<OperationalRiskEventLogDto> listAll();
}
