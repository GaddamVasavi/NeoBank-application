package com.neobank.syndication;
import java.util.List; import java.util.UUID;
public interface IntercreditorAgreementRecordService {
    List<IntercreditorAgreementRecordDto> getByUser(UUID userId);
    IntercreditorAgreementRecordDto create(IntercreditorAgreementRecordDto dto);
    IntercreditorAgreementRecordDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<IntercreditorAgreementRecordDto> listAll();
}
