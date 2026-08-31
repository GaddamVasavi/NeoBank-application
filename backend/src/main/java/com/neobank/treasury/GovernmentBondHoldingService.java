package com.neobank.treasury;
import java.util.List; import java.util.UUID;
public interface GovernmentBondHoldingService {
    List<GovernmentBondHoldingDto> getByUser(UUID userId);
    GovernmentBondHoldingDto create(GovernmentBondHoldingDto dto);
    GovernmentBondHoldingDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<GovernmentBondHoldingDto> listAll();
}
