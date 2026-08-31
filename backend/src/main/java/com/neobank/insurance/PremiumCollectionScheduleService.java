package com.neobank.insurance;
import java.util.List; import java.util.UUID;
public interface PremiumCollectionScheduleService {
    List<PremiumCollectionScheduleDto> getByUser(UUID userId);
    PremiumCollectionScheduleDto create(PremiumCollectionScheduleDto dto);
    PremiumCollectionScheduleDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<PremiumCollectionScheduleDto> listAll();
}
