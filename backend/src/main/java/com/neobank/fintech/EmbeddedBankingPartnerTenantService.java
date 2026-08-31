package com.neobank.fintech;
import java.util.List; import java.util.UUID;
public interface EmbeddedBankingPartnerTenantService {
    List<EmbeddedBankingPartnerTenantDto> getByUser(UUID userId);
    EmbeddedBankingPartnerTenantDto create(EmbeddedBankingPartnerTenantDto dto);
    EmbeddedBankingPartnerTenantDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<EmbeddedBankingPartnerTenantDto> listAll();
}
