package com.neobank.settlement;
import java.util.List; import java.util.UUID;
public interface InterbankNettingCycleService {
    List<InterbankNettingCycleDto> getByUser(UUID userId);
    InterbankNettingCycleDto create(InterbankNettingCycleDto dto);
    InterbankNettingCycleDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<InterbankNettingCycleDto> listAll();
}
