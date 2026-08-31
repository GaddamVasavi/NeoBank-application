package com.neobank.custody;
import java.util.List; import java.util.UUID;
public interface CorporateActionVoteRecordService {
    List<CorporateActionVoteRecordDto> getByUser(UUID userId);
    CorporateActionVoteRecordDto create(CorporateActionVoteRecordDto dto);
    CorporateActionVoteRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CorporateActionVoteRecordDto> listAll();
}
