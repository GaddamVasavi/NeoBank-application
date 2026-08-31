package com.neobank.governance;
import java.util.List; import java.util.UUID;
public interface ShareholderProposalRecordService {
    List<ShareholderProposalRecordDto> getByUser(UUID userId);
    ShareholderProposalRecordDto create(ShareholderProposalRecordDto dto);
    ShareholderProposalRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ShareholderProposalRecordDto> listAll();
}
