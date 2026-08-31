package com.neobank.fx;
import java.util.List; import java.util.UUID;
public interface LiquidityProviderAggregatorService {
    List<LiquidityProviderAggregatorDto> getByUser(UUID userId);
    LiquidityProviderAggregatorDto create(LiquidityProviderAggregatorDto dto);
    LiquidityProviderAggregatorDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<LiquidityProviderAggregatorDto> listAll();
}
