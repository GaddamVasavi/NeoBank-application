package com.neobank.custody;
import java.util.List; import java.util.UUID;
public interface ProxyVotingMandateRecordService {
    List<ProxyVotingMandateRecordDto> getByUser(UUID userId);
    ProxyVotingMandateRecordDto create(ProxyVotingMandateRecordDto dto);
    ProxyVotingMandateRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ProxyVotingMandateRecordDto> listAll();
}
