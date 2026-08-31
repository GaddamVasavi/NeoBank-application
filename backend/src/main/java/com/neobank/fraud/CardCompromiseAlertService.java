package com.neobank.fraud;
import java.util.List; import java.util.UUID;
public interface CardCompromiseAlertService {
    List<CardCompromiseAlertDto> getByUser(UUID userId);
    CardCompromiseAlertDto create(CardCompromiseAlertDto dto);
    CardCompromiseAlertDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CardCompromiseAlertDto> listAll();
}
