package com.neobank.wealth;
import java.util.List; import java.util.UUID;
public interface HedgeFundSubscriptionService {
    List<HedgeFundSubscriptionDto> getByUser(UUID userId);
    HedgeFundSubscriptionDto create(HedgeFundSubscriptionDto dto);
    HedgeFundSubscriptionDto getByCode(String code);
    void updateState(UUID id, String state);
    List<HedgeFundSubscriptionDto> listAll();
}
