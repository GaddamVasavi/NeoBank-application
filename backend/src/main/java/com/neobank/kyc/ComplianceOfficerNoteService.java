package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface ComplianceOfficerNoteService {
    List<ComplianceOfficerNoteDto> getByUser(UUID userId);
    ComplianceOfficerNoteDto create(ComplianceOfficerNoteDto dto);
    ComplianceOfficerNoteDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<ComplianceOfficerNoteDto> listAll();
}
