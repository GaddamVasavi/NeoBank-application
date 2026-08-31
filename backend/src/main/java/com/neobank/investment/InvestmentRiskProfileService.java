package com.neobank.investment;
import java.util.List; import java.util.UUID;
public interface InvestmentRiskProfileService {
    List<InvestmentRiskProfileDto> getByUser(UUID userId);
    InvestmentRiskProfileDto create(InvestmentRiskProfileDto dto);
    InvestmentRiskProfileDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<InvestmentRiskProfileDto> listAll();
}
