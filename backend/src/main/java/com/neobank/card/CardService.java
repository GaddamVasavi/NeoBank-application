package com.neobank.card;
import java.math.BigDecimal; import java.util.List; import java.util.UUID;
public interface CardService {
    List<CardDto> getUserCards(UUID userId);
    CardDto issueCard(UUID userId, UUID accountId, CardType type, boolean isVirtual);
    CardDto toggleFreeze(UUID userId, UUID cardId);
    CardDto updateControls(UUID userId, UUID cardId, boolean online, boolean international, boolean contactless, BigDecimal dailyLimit);
    void setPin(UUID userId, UUID cardId, String newPin);
}
