package com.neobank.digitalvault;
import java.util.List; import java.util.UUID;
public interface DigitalIdentityClaimRecordService {
    List<DigitalIdentityClaimRecordDto> getByUser(UUID userId);
    DigitalIdentityClaimRecordDto create(DigitalIdentityClaimRecordDto dto);
    DigitalIdentityClaimRecordDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<DigitalIdentityClaimRecordDto> listAll();
}
