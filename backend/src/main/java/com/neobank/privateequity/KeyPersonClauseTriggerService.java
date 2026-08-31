package com.neobank.privateequity;
import java.util.List; import java.util.UUID;
public interface KeyPersonClauseTriggerService {
    List<KeyPersonClauseTriggerDto> getByUser(UUID userId);
    KeyPersonClauseTriggerDto create(KeyPersonClauseTriggerDto dto);
    KeyPersonClauseTriggerDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<KeyPersonClauseTriggerDto> listAll();
}
