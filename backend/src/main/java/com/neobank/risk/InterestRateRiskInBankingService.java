package com.neobank.risk;
import java.util.List; import java.util.UUID;
public interface InterestRateRiskInBankingService {
    List<InterestRateRiskInBankingDto> getByUser(UUID userId);
    InterestRateRiskInBankingDto create(InterestRateRiskInBankingDto dto);
    InterestRateRiskInBankingDto getByCode(String code);
    void updateState(UUID id, String state);
    List<InterestRateRiskInBankingDto> listAll();
}
