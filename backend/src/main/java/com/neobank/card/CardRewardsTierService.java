package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface CardRewardsTierService {
    List<CardRewardsTierDto> getByUser(UUID userId);
    CardRewardsTierDto create(CardRewardsTierDto dto);
    CardRewardsTierDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CardRewardsTierDto> listAll();
}
