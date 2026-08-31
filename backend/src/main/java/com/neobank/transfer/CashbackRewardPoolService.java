package com.neobank.transfer;
import java.util.List; import java.util.UUID;
public interface CashbackRewardPoolService {
    List<CashbackRewardPoolDto> getByAccount(UUID accountId);
    CashbackRewardPoolDto create(CashbackRewardPoolDto dto);
    CashbackRewardPoolDto getByTrackingNumber(String trackingNumber);
    void process(UUID id);
}
