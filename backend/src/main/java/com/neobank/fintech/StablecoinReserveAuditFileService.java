package com.neobank.fintech;
import java.util.List; import java.util.UUID;
public interface StablecoinReserveAuditFileService {
    List<StablecoinReserveAuditFileDto> getByUser(UUID userId);
    StablecoinReserveAuditFileDto create(StablecoinReserveAuditFileDto dto);
    StablecoinReserveAuditFileDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<StablecoinReserveAuditFileDto> listAll();
}
