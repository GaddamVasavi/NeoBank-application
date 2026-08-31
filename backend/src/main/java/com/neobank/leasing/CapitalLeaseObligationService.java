package com.neobank.leasing;
import java.util.List; import java.util.UUID;
public interface CapitalLeaseObligationService {
    List<CapitalLeaseObligationDto> getByUser(UUID userId);
    CapitalLeaseObligationDto create(CapitalLeaseObligationDto dto);
    CapitalLeaseObligationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CapitalLeaseObligationDto> listAll();
}
