package com.neobank.privateequity;
import java.util.List; import java.util.UUID;
public interface SideLetterAgreementRecordService {
    List<SideLetterAgreementRecordDto> getByUser(UUID userId);
    SideLetterAgreementRecordDto create(SideLetterAgreementRecordDto dto);
    SideLetterAgreementRecordDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<SideLetterAgreementRecordDto> listAll();
}
