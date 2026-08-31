package com.neobank.pension;
import java.util.List; import java.util.UUID;
public interface ContributionSchedule401kService {
    List<ContributionSchedule401kDto> getByUser(UUID userId);
    ContributionSchedule401kDto create(ContributionSchedule401kDto dto);
    ContributionSchedule401kDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ContributionSchedule401kDto> listAll();
}
