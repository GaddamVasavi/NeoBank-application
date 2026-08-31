package com.neobank.settlement;
import java.util.List; import java.util.UUID;
public interface LiquidityBufferAllocationService {
    List<LiquidityBufferAllocationDto> getByUser(UUID userId);
    LiquidityBufferAllocationDto create(LiquidityBufferAllocationDto dto);
    LiquidityBufferAllocationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<LiquidityBufferAllocationDto> listAll();
}
