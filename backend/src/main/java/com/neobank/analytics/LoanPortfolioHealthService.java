package com.neobank.analytics;
import java.util.List; import java.util.UUID;
public interface LoanPortfolioHealthService {
    List<LoanPortfolioHealthDto> getByUser(UUID userId);
    LoanPortfolioHealthDto create(LoanPortfolioHealthDto dto);
    LoanPortfolioHealthDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<LoanPortfolioHealthDto> listAll();
}
