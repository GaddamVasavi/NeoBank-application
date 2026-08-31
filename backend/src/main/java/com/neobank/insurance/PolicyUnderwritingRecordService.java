package com.neobank.insurance;
import java.util.List; import java.util.UUID;
public interface PolicyUnderwritingRecordService {
    List<PolicyUnderwritingRecordDto> getByUser(UUID userId);
    PolicyUnderwritingRecordDto create(PolicyUnderwritingRecordDto dto);
    PolicyUnderwritingRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<PolicyUnderwritingRecordDto> listAll();
}
