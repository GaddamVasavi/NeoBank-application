package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface CardContactlessLimitService {
    List<CardContactlessLimitDto> getByUser(UUID userId);
    CardContactlessLimitDto create(CardContactlessLimitDto dto);
    CardContactlessLimitDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CardContactlessLimitDto> listAll();
}
