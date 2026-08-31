package com.neobank.insurance;
import java.util.List; import java.util.UUID;
public interface TravelMedicalCoverageLogService {
    List<TravelMedicalCoverageLogDto> getByUser(UUID userId);
    TravelMedicalCoverageLogDto create(TravelMedicalCoverageLogDto dto);
    TravelMedicalCoverageLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<TravelMedicalCoverageLogDto> listAll();
}
