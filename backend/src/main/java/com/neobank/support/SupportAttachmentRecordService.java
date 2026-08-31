package com.neobank.support;
import java.util.List; import java.util.UUID;
public interface SupportAttachmentRecordService {
    List<SupportAttachmentRecordDto> getByUser(UUID userId);
    SupportAttachmentRecordDto create(SupportAttachmentRecordDto dto);
    SupportAttachmentRecordDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SupportAttachmentRecordDto> listAll();
}
