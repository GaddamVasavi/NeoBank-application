package com.neobank.treasuryoperations;
import java.util.List; import java.util.UUID;
public interface CentralBankAuctionTenderService {
    List<CentralBankAuctionTenderDto> getByUser(UUID userId);
    CentralBankAuctionTenderDto create(CentralBankAuctionTenderDto dto);
    CentralBankAuctionTenderDto getByIdentifier(String id);
    void updateStatus(UUID id, String status);
    List<CentralBankAuctionTenderDto> listAll();
}
