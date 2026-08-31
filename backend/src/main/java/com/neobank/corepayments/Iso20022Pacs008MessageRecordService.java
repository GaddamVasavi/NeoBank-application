package com.neobank.corepayments;
import java.util.List; import java.util.UUID;
public interface Iso20022Pacs008MessageRecordService {
    List<Iso20022Pacs008MessageRecordDto> getByUser(UUID userId);
    Iso20022Pacs008MessageRecordDto create(Iso20022Pacs008MessageRecordDto dto);
    Iso20022Pacs008MessageRecordDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<Iso20022Pacs008MessageRecordDto> listAll();
}
