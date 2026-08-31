package com.neobank.fintech;
import java.util.List; import java.util.UUID;
public interface OpenFinanceAccountConsentService {
    List<OpenFinanceAccountConsentDto> getByUser(UUID userId);
    OpenFinanceAccountConsentDto create(OpenFinanceAccountConsentDto dto);
    OpenFinanceAccountConsentDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<OpenFinanceAccountConsentDto> listAll();
}
