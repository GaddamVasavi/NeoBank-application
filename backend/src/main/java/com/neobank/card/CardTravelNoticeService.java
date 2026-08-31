package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface CardTravelNoticeService {
    List<CardTravelNoticeDto> getByUser(UUID userId);
    CardTravelNoticeDto create(CardTravelNoticeDto dto);
    CardTravelNoticeDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CardTravelNoticeDto> listAll();
}
