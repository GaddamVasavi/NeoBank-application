package com.neobank.marketing;
import java.util.List; import java.util.UUID;
public interface LoyaltyRewardCatalogItemService {
    List<LoyaltyRewardCatalogItemDto> getByUser(UUID userId);
    LoyaltyRewardCatalogItemDto create(LoyaltyRewardCatalogItemDto dto);
    LoyaltyRewardCatalogItemDto getByCode(String code);
    void updateState(UUID id, String state);
    List<LoyaltyRewardCatalogItemDto> listAll();
}
