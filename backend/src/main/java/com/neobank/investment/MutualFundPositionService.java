package com.neobank.investment;
import java.util.List; import java.util.UUID;
public interface MutualFundPositionService {
    List<MutualFundPositionDto> getByUser(UUID userId);
    MutualFundPositionDto create(MutualFundPositionDto dto);
    MutualFundPositionDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<MutualFundPositionDto> listAll();
}
