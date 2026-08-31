package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface CardGeoFencingControlService {
    List<CardGeoFencingControlDto> getByUser(UUID userId);
    CardGeoFencingControlDto create(CardGeoFencingControlDto dto);
    CardGeoFencingControlDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
