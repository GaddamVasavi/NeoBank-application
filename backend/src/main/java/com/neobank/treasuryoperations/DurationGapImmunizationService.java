package com.neobank.treasuryoperations;
import java.util.List; import java.util.UUID;
public interface DurationGapImmunizationService {
    List<DurationGapImmunizationDto> getByUser(UUID userId);
    DurationGapImmunizationDto create(DurationGapImmunizationDto dto);
    DurationGapImmunizationDto getByIdentifier(String id);
    void updateStatus(UUID id, String status);
    List<DurationGapImmunizationDto> listAll();
}
