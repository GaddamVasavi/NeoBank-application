package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface CardPinVerificationLogService {
    List<CardPinVerificationLogDto> getByUser(UUID userId);
    CardPinVerificationLogDto create(CardPinVerificationLogDto dto);
    CardPinVerificationLogDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CardPinVerificationLogDto> listAll();
}
