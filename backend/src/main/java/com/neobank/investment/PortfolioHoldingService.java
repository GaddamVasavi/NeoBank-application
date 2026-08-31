package com.neobank.investment;
import java.util.List; import java.util.UUID;
public interface PortfolioHoldingService {
    List<PortfolioHoldingDto> getByUser(UUID userId);
    PortfolioHoldingDto create(PortfolioHoldingDto dto);
    PortfolioHoldingDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<PortfolioHoldingDto> listAll();
}
