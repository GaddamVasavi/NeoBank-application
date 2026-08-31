package com.neobank.support;
import java.util.List; import java.util.UUID;
public interface TicketResolutionMetricService {
    List<TicketResolutionMetricDto> getByUser(UUID userId);
    TicketResolutionMetricDto create(TicketResolutionMetricDto dto);
    TicketResolutionMetricDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<TicketResolutionMetricDto> listAll();
}
