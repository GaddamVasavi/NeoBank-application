package com.neobank.notificationservice;
import java.util.List; import java.util.UUID;
public interface EmailDispatchArchiveRecordService {
    List<EmailDispatchArchiveRecordDto> getByUser(UUID userId);
    EmailDispatchArchiveRecordDto create(EmailDispatchArchiveRecordDto dto);
    EmailDispatchArchiveRecordDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<EmailDispatchArchiveRecordDto> listAll();
}
