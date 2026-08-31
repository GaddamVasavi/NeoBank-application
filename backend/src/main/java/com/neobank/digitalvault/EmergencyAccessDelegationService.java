package com.neobank.digitalvault;
import java.util.List; import java.util.UUID;
public interface EmergencyAccessDelegationService {
    List<EmergencyAccessDelegationDto> getByUser(UUID userId);
    EmergencyAccessDelegationDto create(EmergencyAccessDelegationDto dto);
    EmergencyAccessDelegationDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<EmergencyAccessDelegationDto> listAll();
}
