package com.neobank.syndicatedloans;
import java.util.List; import java.util.UUID;
public interface LenderVotingRecordService {
    List<LenderVotingRecordDto> getByUser(UUID userId);
    LenderVotingRecordDto create(LenderVotingRecordDto dto);
    LenderVotingRecordDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<LenderVotingRecordDto> listAll();
}
