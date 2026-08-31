package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface CardMerchantBlacklistService {
    List<CardMerchantBlacklistDto> getByUser(UUID userId);
    CardMerchantBlacklistDto create(CardMerchantBlacklistDto dto);
    CardMerchantBlacklistDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CardMerchantBlacklistDto> listAll();
}
