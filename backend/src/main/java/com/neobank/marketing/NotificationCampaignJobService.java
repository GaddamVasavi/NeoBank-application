package com.neobank.marketing;
import java.util.List; import java.util.UUID;
public interface NotificationCampaignJobService {
    List<NotificationCampaignJobDto> getByUser(UUID userId);
    NotificationCampaignJobDto create(NotificationCampaignJobDto dto);
    NotificationCampaignJobDto getByCode(String code);
    void updateState(UUID id, String state);
    List<NotificationCampaignJobDto> listAll();
}
