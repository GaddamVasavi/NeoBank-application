package com.neobank.digitalvault;
import java.util.List; import java.util.UUID;
public interface HardwareSecurityModuleAuditService {
    List<HardwareSecurityModuleAuditDto> getByUser(UUID userId);
    HardwareSecurityModuleAuditDto create(HardwareSecurityModuleAuditDto dto);
    HardwareSecurityModuleAuditDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<HardwareSecurityModuleAuditDto> listAll();
}
