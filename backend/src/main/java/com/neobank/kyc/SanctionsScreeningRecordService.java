package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface SanctionsScreeningRecordService {
    List<SanctionsScreeningRecordDto> getByUser(UUID userId);
    SanctionsScreeningRecordDto create(SanctionsScreeningRecordDto dto);
    SanctionsScreeningRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
