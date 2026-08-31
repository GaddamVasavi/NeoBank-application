package com.neobank.treasuryfx;
import java.util.List; import java.util.UUID;
public interface TreasuryBillAuctionBidLogService {
    List<TreasuryBillAuctionBidLogDto> getByUser(UUID userId);
    TreasuryBillAuctionBidLogDto create(TreasuryBillAuctionBidLogDto dto);
    TreasuryBillAuctionBidLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<TreasuryBillAuctionBidLogDto> listAll();
}
