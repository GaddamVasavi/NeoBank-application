package com.neobank.interbankclearing;
import java.util.List; import java.util.UUID;
public interface Target2GrossSettlementLogService {
    List<Target2GrossSettlementLogDto> getByUser(UUID userId);
    Target2GrossSettlementLogDto create(Target2GrossSettlementLogDto dto);
    Target2GrossSettlementLogDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<Target2GrossSettlementLogDto> listAll();
}
