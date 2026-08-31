package com.neobank.digitalvault;
import java.util.List; import java.util.UUID;
public interface SessionRevocationBroadcastService {
    List<SessionRevocationBroadcastDto> getByUser(UUID userId);
    SessionRevocationBroadcastDto create(SessionRevocationBroadcastDto dto);
    SessionRevocationBroadcastDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<SessionRevocationBroadcastDto> listAll();
}
