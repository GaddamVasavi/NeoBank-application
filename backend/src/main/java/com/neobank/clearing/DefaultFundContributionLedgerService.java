package com.neobank.clearing;
import java.util.List; import java.util.UUID;
public interface DefaultFundContributionLedgerService {
    List<DefaultFundContributionLedgerDto> getByUser(UUID userId);
    DefaultFundContributionLedgerDto create(DefaultFundContributionLedgerDto dto);
    DefaultFundContributionLedgerDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DefaultFundContributionLedgerDto> listAll();
}
