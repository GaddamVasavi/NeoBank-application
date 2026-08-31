package com.neobank.card;
import java.util.List; import java.util.UUID;
public interface CardReplacementRequestService {
    List<CardReplacementRequestDto> getByUser(UUID userId);
    CardReplacementRequestDto create(CardReplacementRequestDto dto);
    CardReplacementRequestDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
