package com.neobank.corporate;
import java.util.List; import java.util.UUID;
public interface SweepAccountArrangementService {
    List<SweepAccountArrangementDto> getByUser(UUID userId);
    SweepAccountArrangementDto create(SweepAccountArrangementDto dto);
    SweepAccountArrangementDto getByCode(String code);
    void updateState(UUID id, String state);
    List<SweepAccountArrangementDto> listAll();
}
