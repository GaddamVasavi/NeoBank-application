package com.neobank.support;
import java.util.List; import java.util.UUID;
public interface SupportChatMessageService {
    List<SupportChatMessageDto> getByUser(UUID userId);
    SupportChatMessageDto create(SupportChatMessageDto dto);
    SupportChatMessageDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SupportChatMessageDto> listAll();
}
