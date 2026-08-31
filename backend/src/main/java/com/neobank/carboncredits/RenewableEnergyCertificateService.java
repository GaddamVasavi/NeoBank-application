package com.neobank.carboncredits;
import java.util.List; import java.util.UUID;
public interface RenewableEnergyCertificateService {
    List<RenewableEnergyCertificateDto> getByUser(UUID userId);
    RenewableEnergyCertificateDto create(RenewableEnergyCertificateDto dto);
    RenewableEnergyCertificateDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<RenewableEnergyCertificateDto> listAll();
}
