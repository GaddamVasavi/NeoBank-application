package com.neobank.support;
import java.util.List; import java.util.UUID;
public interface SupportTicketCategoryService {
    List<SupportTicketCategoryDto> getByUser(UUID userId);
    SupportTicketCategoryDto create(SupportTicketCategoryDto dto);
    SupportTicketCategoryDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<SupportTicketCategoryDto> listAll();
}
