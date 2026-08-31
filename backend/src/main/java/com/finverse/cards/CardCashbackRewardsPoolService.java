package com.finverse.cards;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for CardCashbackRewardsPool
 */
public interface CardCashbackRewardsPoolService {

    List<CardCashbackRewardsPoolDto> getByTenant(UUID tenantId);

    List<CardCashbackRewardsPoolDto> getByUser(UUID userId);

    CardCashbackRewardsPoolDto create(CardCashbackRewardsPoolDto dto);

    CardCashbackRewardsPoolDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<CardCashbackRewardsPoolDto> listAll();
}
