package com.neobank.openbanking;
import java.util.List; import java.util.UUID;
public interface DynamicClientRegistrationRecordService {
    List<DynamicClientRegistrationRecordDto> getByUser(UUID userId);
    DynamicClientRegistrationRecordDto create(DynamicClientRegistrationRecordDto dto);
    DynamicClientRegistrationRecordDto getByCode(String code);
    void updateState(UUID id, String state);
    List<DynamicClientRegistrationRecordDto> listAll();
}
