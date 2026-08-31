package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface CardDesignThemeService {
    List<CardDesignThemeDto> getByUser(UUID userId);
    CardDesignThemeDto create(CardDesignThemeDto dto);
    CardDesignThemeDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CardDesignThemeDto> listAll();
}
