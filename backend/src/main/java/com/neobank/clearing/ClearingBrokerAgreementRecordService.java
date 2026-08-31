package com.neobank.clearing;
import java.util.List; import java.util.UUID;
public interface ClearingBrokerAgreementRecordService {
    List<ClearingBrokerAgreementRecordDto> getByUser(UUID userId);
    ClearingBrokerAgreementRecordDto create(ClearingBrokerAgreementRecordDto dto);
    ClearingBrokerAgreementRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ClearingBrokerAgreementRecordDto> listAll();
}
