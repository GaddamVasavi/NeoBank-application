package com.neobank.syndication;
import java.util.List; import java.util.UUID;
public interface LeadArrangerMandateAgreementService {
    List<LeadArrangerMandateAgreementDto> getByUser(UUID userId);
    LeadArrangerMandateAgreementDto create(LeadArrangerMandateAgreementDto dto);
    LeadArrangerMandateAgreementDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<LeadArrangerMandateAgreementDto> listAll();
}
