package com.neobank.syndicatedloans;
import java.util.List; import java.util.UUID;
public interface AgentBankNoticeBroadcastService {
    List<AgentBankNoticeBroadcastDto> getByUser(UUID userId);
    AgentBankNoticeBroadcastDto create(AgentBankNoticeBroadcastDto dto);
    AgentBankNoticeBroadcastDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<AgentBankNoticeBroadcastDto> listAll();
}
