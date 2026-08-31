package com.neobank.trade;
import java.util.List; import java.util.UUID;
public interface ForfaitingContractAgreementService {
    List<ForfaitingContractAgreementDto> getByUser(UUID userId);
    ForfaitingContractAgreementDto create(ForfaitingContractAgreementDto dto);
    ForfaitingContractAgreementDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ForfaitingContractAgreementDto> listAll();
}
