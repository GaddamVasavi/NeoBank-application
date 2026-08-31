package com.neobank.marketing;
import java.util.List; import java.util.UUID;
public interface ReferralBonusLedgerEntryService {
    List<ReferralBonusLedgerEntryDto> getByUser(UUID userId);
    ReferralBonusLedgerEntryDto create(ReferralBonusLedgerEntryDto dto);
    ReferralBonusLedgerEntryDto getByCode(String code);
    void updateState(UUID id, String state);
    List<ReferralBonusLedgerEntryDto> listAll();
}
