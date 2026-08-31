package com.neobank.carboncredits;
import java.util.List; import java.util.UUID;
public interface CarbonAllowanceAuctionBidService {
    List<CarbonAllowanceAuctionBidDto> getByUser(UUID userId);
    CarbonAllowanceAuctionBidDto create(CarbonAllowanceAuctionBidDto dto);
    CarbonAllowanceAuctionBidDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<CarbonAllowanceAuctionBidDto> listAll();
}
