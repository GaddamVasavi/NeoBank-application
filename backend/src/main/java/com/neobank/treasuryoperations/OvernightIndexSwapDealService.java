package com.neobank.treasuryoperations;
import java.util.List; import java.util.UUID;
public interface OvernightIndexSwapDealService {
    List<OvernightIndexSwapDealDto> getByUser(UUID userId);
    OvernightIndexSwapDealDto create(OvernightIndexSwapDealDto dto);
    OvernightIndexSwapDealDto getByIdentifier(String id);
    void updateStatus(UUID id, String status);
    List<OvernightIndexSwapDealDto> listAll();
}
