package com.neobank.fintech;
import java.util.List; import java.util.UUID;
public interface CryptoCustodyLedgerEntryService {
    List<CryptoCustodyLedgerEntryDto> getByUser(UUID userId);
    CryptoCustodyLedgerEntryDto create(CryptoCustodyLedgerEntryDto dto);
    CryptoCustodyLedgerEntryDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CryptoCustodyLedgerEntryDto> listAll();
}
