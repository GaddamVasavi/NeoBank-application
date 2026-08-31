package com.neobank.marketing;
import java.util.List; import java.util.UUID;
public interface PromotionalCampaignScheduleService {
    List<PromotionalCampaignScheduleDto> getByUser(UUID userId);
    PromotionalCampaignScheduleDto create(PromotionalCampaignScheduleDto dto);
    PromotionalCampaignScheduleDto getByCode(String code);
    void updateState(UUID id, String state);
    List<PromotionalCampaignScheduleDto> listAll();
}
