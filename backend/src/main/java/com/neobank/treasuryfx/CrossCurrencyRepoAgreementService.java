package com.neobank.treasuryfx;
import java.util.List; import java.util.UUID;
public interface CrossCurrencyRepoAgreementService {
    List<CrossCurrencyRepoAgreementDto> getByUser(UUID userId);
    CrossCurrencyRepoAgreementDto create(CrossCurrencyRepoAgreementDto dto);
    CrossCurrencyRepoAgreementDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CrossCurrencyRepoAgreementDto> listAll();
}
