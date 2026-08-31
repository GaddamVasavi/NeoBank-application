package com.neobank.treasuryfx;
import java.util.List; import java.util.UUID;
public interface PrimaryDealerAuctionBidService {
    List<PrimaryDealerAuctionBidDto> getByUser(UUID userId);
    PrimaryDealerAuctionBidDto create(PrimaryDealerAuctionBidDto dto);
    PrimaryDealerAuctionBidDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<PrimaryDealerAuctionBidDto> listAll();
}
