package com.neobank.support;
import java.util.List; import java.util.UUID;
public interface TicketEscalationLogService {
    List<TicketEscalationLogDto> getByUser(UUID userId);
    TicketEscalationLogDto create(TicketEscalationLogDto dto);
    TicketEscalationLogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<TicketEscalationLogDto> listAll();
}
