package com.neobank.privateequity;
import java.util.List; import java.util.UUID;
public interface PortfolioCompanyValuationService {
    List<PortfolioCompanyValuationDto> getByUser(UUID userId);
    PortfolioCompanyValuationDto create(PortfolioCompanyValuationDto dto);
    PortfolioCompanyValuationDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<PortfolioCompanyValuationDto> listAll();
}
