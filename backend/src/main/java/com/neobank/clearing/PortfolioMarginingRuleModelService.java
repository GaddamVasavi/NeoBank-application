package com.neobank.clearing;
import java.util.List; import java.util.UUID;
public interface PortfolioMarginingRuleModelService {
    List<PortfolioMarginingRuleModelDto> getByUser(UUID userId);
    PortfolioMarginingRuleModelDto create(PortfolioMarginingRuleModelDto dto);
    PortfolioMarginingRuleModelDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<PortfolioMarginingRuleModelDto> listAll();
}
