package com.neobank.collateral;
import java.util.List; import java.util.UUID;
public interface SecuritiesPledgeAgreementService {
    List<SecuritiesPledgeAgreementDto> getByUser(UUID userId);
    SecuritiesPledgeAgreementDto create(SecuritiesPledgeAgreementDto dto);
    SecuritiesPledgeAgreementDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<SecuritiesPledgeAgreementDto> listAll();
}
