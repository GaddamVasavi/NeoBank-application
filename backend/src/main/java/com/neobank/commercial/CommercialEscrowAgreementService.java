package com.neobank.commercial;
import java.util.List; import java.util.UUID;
public interface CommercialEscrowAgreementService {
    List<CommercialEscrowAgreementDto> getByUser(UUID userId);
    CommercialEscrowAgreementDto create(CommercialEscrowAgreementDto dto);
    CommercialEscrowAgreementDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<CommercialEscrowAgreementDto> listAll();
}
